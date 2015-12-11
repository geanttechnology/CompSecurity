.class Lcom/comcast/cim/container/PlayerContainer$10;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/OrientationStrategy;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
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
    .line 1036
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$10;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppropriateOrientation()I
    .locals 2

    .prologue
    .line 1039
    const/4 v0, 0x4

    .line 1040
    .local v0, "orientation":I
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer$10;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isTabletDevice()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1041
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer$10;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->getPortraitOrientation()I

    move-result v0

    .line 1044
    :cond_0
    return v0
.end method
