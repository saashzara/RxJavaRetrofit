package sys.almas.rxjavaretrofitexample.model;


public class SampleModel extends BaseServerResponse {

    /**
     * CommandID : 11
     * Commandtype : 1
     * Command : 1297385394
     * ImageUrl : null
     * NetworkUserName : 989028381217
     * InsertDate : 2018-08-15T10:57:08.2254191
     * SendingDate : 2018-08-15T10:56:58
     * ExpireDate : 2018-08-16T10:57:01
     * PlatformType : 2
     * VideoURL : null
     * Text : timeout test
     * CommandState : pending
     */

    private int CommandID;
    private int Commandtype;
    private String Command;
    private Object ImageUrl;
    private String NetworkUserName;
    private String InsertDate;
    private String SendingDate;
    private String ExpireDate;
    private int PlatformType;
    private Object VideoURL;
    private String Text;
    private String CommandState;

    public int getCommandID() {
        return CommandID;
    }

    public void setCommandID(int CommandID) {
        this.CommandID = CommandID;
    }

    public int getCommandtype() {
        return Commandtype;
    }

    public void setCommandtype(int Commandtype) {
        this.Commandtype = Commandtype;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String Command) {
        this.Command = Command;
    }

    public Object getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(Object ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getNetworkUserName() {
        return NetworkUserName;
    }

    public void setNetworkUserName(String NetworkUserName) {
        this.NetworkUserName = NetworkUserName;
    }

    public String getInsertDate() {
        return InsertDate;
    }

    public void setInsertDate(String InsertDate) {
        this.InsertDate = InsertDate;
    }

    public String getSendingDate() {
        return SendingDate;
    }

    public void setSendingDate(String SendingDate) {
        this.SendingDate = SendingDate;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public int getPlatformType() {
        return PlatformType;
    }

    public void setPlatformType(int PlatformType) {
        this.PlatformType = PlatformType;
    }

    public Object getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(Object VideoURL) {
        this.VideoURL = VideoURL;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getCommandState() {
        return CommandState;
    }

    public void setCommandState(String CommandState) {
        this.CommandState = CommandState;
    }
}
