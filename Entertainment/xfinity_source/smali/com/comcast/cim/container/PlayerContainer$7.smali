.class Lcom/comcast/cim/container/PlayerContainer$7;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


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
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
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
    .line 846
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$7;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    .locals 1

    .prologue
    .line 849
    new-instance v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 846
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer$7;->get()Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    move-result-object v0

    return-object v0
.end method
