.class Lcom/comcast/cim/container/PlayerContainer$8;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/initializer/Initializer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getUserSettingsDao()Lcom/comcast/cim/model/user/service/UserSettingsDao;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/initializer/Initializer",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 852
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$8;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initialize(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 1
    .param p1, "playerUserSettings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 855
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer$8;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicProgramFilterFactory()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setFilterFactory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;)V

    .line 856
    return-void
.end method

.method public bridge synthetic initialize(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 852
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/container/PlayerContainer$8;->initialize(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method
