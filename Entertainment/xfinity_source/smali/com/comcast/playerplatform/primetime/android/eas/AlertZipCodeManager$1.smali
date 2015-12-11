.class Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "AlertZipCodeManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public requestFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryFips()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V

    .line 46
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 4
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 30
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->parseFipsCodeResponse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->fipsCode:Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$002(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;Ljava/lang/String;)Ljava/lang/String;

    .line 32
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->fipsCode:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$000(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 33
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->fipsCode:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$000(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->fipsCodeFound(Ljava/lang/String;)V

    .line 41
    :goto_0
    return-void

    .line 35
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to receive fips from uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->zipsToFipsUri:Ljava/lang/String;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V

    .line 36
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryFips()V
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 38
    :catch_0
    move-exception v0

    .line 39
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to receive fips from zipcode. Exception occured: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V

    goto :goto_0
.end method
