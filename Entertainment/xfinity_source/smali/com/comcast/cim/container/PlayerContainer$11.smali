.class Lcom/comcast/cim/container/PlayerContainer$11;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/OrientationStrategy;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getSensorIfHasKeyboardOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 1057
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$11;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppropriateOrientation()I
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 1060
    const/4 v1, 0x4

    .line 1062
    .local v1, "orientation":I
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer$11;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    iget v2, v2, Landroid/content/res/Configuration;->keyboard:I

    if-eq v2, v0, :cond_1

    .line 1064
    .local v0, "hasHardwareKeyboard":Z
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer$11;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->getDevicePhysicalSize()I

    move-result v2

    const/4 v3, 0x3

    if-ge v2, v3, :cond_0

    if-nez v0, :cond_0

    .line 1065
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer$11;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->getPortraitOrientation()I

    move-result v1

    .line 1068
    :cond_0
    return v1

    .line 1062
    .end local v0    # "hasHardwareKeyboard":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
