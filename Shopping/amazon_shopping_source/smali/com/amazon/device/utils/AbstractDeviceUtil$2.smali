.class Lcom/amazon/device/utils/AbstractDeviceUtil$2;
.super Ljava/lang/Object;
.source "AbstractDeviceUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/utils/AbstractDeviceUtil;->createSessionID()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;


# direct methods
.method constructor <init>(Lcom/amazon/device/utils/AbstractDeviceUtil;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v8, 0x7

    const/4 v7, 0x3

    .line 161
    const/4 v1, 0x0

    .line 162
    .local v1, "sessionId":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    iget-object v3, v3, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v4, "clickstreamSessionID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 163
    if-nez v1, :cond_0

    .line 164
    new-instance v2, Ljava/security/SecureRandom;

    invoke-direct {v2}, Ljava/security/SecureRandom;-><init>()V

    .line 166
    .local v2, "sr":Ljava/security/SecureRandom;
    const-string/jumbo v3, "%s-%s-%s"

    new-array v4, v7, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    # invokes: Lcom/amazon/device/utils/AbstractDeviceUtil;->getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;
    invoke-static {v6, v7, v2}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$000(Lcom/amazon/device/utils/AbstractDeviceUtil;ILjava/security/SecureRandom;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    # invokes: Lcom/amazon/device/utils/AbstractDeviceUtil;->getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;
    invoke-static {v6, v8, v2}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$000(Lcom/amazon/device/utils/AbstractDeviceUtil;ILjava/security/SecureRandom;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    # invokes: Lcom/amazon/device/utils/AbstractDeviceUtil;->getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;
    invoke-static {v6, v8, v2}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$000(Lcom/amazon/device/utils/AbstractDeviceUtil;ILjava/security/SecureRandom;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 167
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    iget-object v3, v3, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 168
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v3, "clickstreamSessionID"

    invoke-interface {v0, v3, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 169
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 170
    const-string/jumbo v3, "AbstractDeviceUtil"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Generated a new SessionID"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 172
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "sr":Ljava/security/SecureRandom;
    :cond_0
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$2;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    # setter for: Lcom/amazon/device/utils/AbstractDeviceUtil;->mSessionID:Ljava/lang/String;
    invoke-static {v3, v1}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$202(Lcom/amazon/device/utils/AbstractDeviceUtil;Ljava/lang/String;)Ljava/lang/String;

    .line 173
    return-void
.end method
