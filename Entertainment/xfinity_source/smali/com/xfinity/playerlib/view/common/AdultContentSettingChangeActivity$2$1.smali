.class Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;
.super Ljava/lang/Object;
.source "AdultContentSettingChangeActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->onPostExecute(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;

.field final synthetic val$desiredSetting:Z

.field final synthetic val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

.field final synthetic val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;Z)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->this$1:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    iput-boolean p4, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$desiredSetting:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public validatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 3
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 61
    new-instance v1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-direct {v1, p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 62
    .local v0, "pinValidated":Z
    if-eqz v0, :cond_0

    .line 63
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->val$desiredSetting:Z

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsAdultContent(Z)V

    .line 64
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;->this$1:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->finish()V

    .line 66
    :cond_0
    invoke-interface {p2, v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;->onPinValidationComplete(Z)V

    .line 67
    return-void
.end method
