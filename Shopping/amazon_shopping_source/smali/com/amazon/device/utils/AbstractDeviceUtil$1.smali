.class Lcom/amazon/device/utils/AbstractDeviceUtil$1;
.super Ljava/lang/Object;
.source "AbstractDeviceUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/utils/AbstractDeviceUtil;->createCustomerID()V
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
    .line 134
    iput-object p1, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$1;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 137
    const/4 v0, 0x0

    .line 138
    .local v0, "customerId":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$1;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    iget-object v3, v3, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v4, "clickstreamCustomerID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 139
    if-nez v0, :cond_0

    .line 140
    new-instance v2, Ljava/security/SecureRandom;

    invoke-direct {v2}, Ljava/security/SecureRandom;-><init>()V

    .line 141
    .local v2, "sr":Ljava/security/SecureRandom;
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$1;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    const/16 v4, 0x9

    # invokes: Lcom/amazon/device/utils/AbstractDeviceUtil;->getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;
    invoke-static {v3, v4, v2}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$000(Lcom/amazon/device/utils/AbstractDeviceUtil;ILjava/security/SecureRandom;)Ljava/lang/String;

    move-result-object v0

    .line 142
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$1;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    iget-object v3, v3, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 143
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v3, "clickstreamCustomerID"

    invoke-interface {v1, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 144
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 145
    const-string/jumbo v3, "AbstractDeviceUtil"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Generated a new CustomerId "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "sr":Ljava/security/SecureRandom;
    :cond_0
    iget-object v3, p0, Lcom/amazon/device/utils/AbstractDeviceUtil$1;->this$0:Lcom/amazon/device/utils/AbstractDeviceUtil;

    # setter for: Lcom/amazon/device/utils/AbstractDeviceUtil;->mCustomerID:Ljava/lang/String;
    invoke-static {v3, v0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->access$102(Lcom/amazon/device/utils/AbstractDeviceUtil;Ljava/lang/String;)Ljava/lang/String;

    .line 148
    return-void
.end method
