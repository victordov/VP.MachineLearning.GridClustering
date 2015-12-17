import java.util.ArrayList;

public class ClusterObject {

    private ArrayList<Double> m_lstAttributeList;

    private int m_nObjectId = -1;
    private int m_nClusterId = -1;

    public ClusterObject() {
        m_lstAttributeList = new ArrayList<>();
    }


    public static ClusterObject fromRow(String strLine) {
        return ClusterObject.fromRow(-1, strLine);
    }

    public static ClusterObject fromRow(int nObjectId, String strLine) {

        if (strLine == null || strLine.isEmpty())
            return null;

        String[] strItems = strLine.split(",");
        ClusterObject newObj = new ClusterObject();

        for (String strItem : strItems) {
            newObj.addAttribute(Double.parseDouble(strItem.trim()));
        }

        return newObj;
    }

    public int getObjectId() {
        return m_nObjectId;
    }

    public void setObjectId(int m_nObjectId) {
        this.m_nObjectId = m_nObjectId;
    }

    public int getClusterId() {
        return m_nClusterId;
    }

    public void setClusterId(int m_nClusterId) {
        this.m_nClusterId = m_nClusterId;
    }

    public void addAttribute(double dValue) {
        m_lstAttributeList.add(dValue);
    }

    public double getAttribute(int index) {
        return m_lstAttributeList.get(index);
    }

    public int getSize() {
        return m_lstAttributeList.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String strResult = "";

        sb.append("{");
        for (double d : m_lstAttributeList) {
            sb.append(d);
            sb.append(",");
        }

        strResult = sb.toString().substring(0, sb.length() - 1);
        strResult += "}";

        return strResult;
    }


}
