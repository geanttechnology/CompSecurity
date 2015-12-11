.class public Lcom/comcast/cim/model/user/service/UserSaveTask;
.super Ljava/lang/Object;
.source "UserSaveTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/model/user/User;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private user:Lcom/comcast/cim/model/user/User;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<TT;TS;>;"
        }
    .end annotation
.end field

.field private userSettings:Lcom/comcast/cim/model/user/service/UserSettings;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/comcast/cim/model/user/service/UserSaveTask;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/model/user/service/UserSaveTask;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserManager",
            "<TT;TS;>;TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSaveTask;, "Lcom/comcast/cim/model/user/service/UserSaveTask<TT;TS;>;"
    .local p1, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    .local p2, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p3, "userSettings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 18
    iput-object p2, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->user:Lcom/comcast/cim/model/user/User;

    .line 19
    iput-object p3, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->userSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    .line 20
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/model/user/service/UserSaveTask;, "Lcom/comcast/cim/model/user/service/UserSaveTask<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->userManager:Lcom/comcast/cim/model/user/UserManager;

    iget-object v1, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->user:Lcom/comcast/cim/model/user/User;

    iget-object v2, p0, Lcom/comcast/cim/model/user/service/UserSaveTask;->userSettings:Lcom/comcast/cim/model/user/service/UserSettings;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/model/user/UserManager;->saveUser(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 25
    return-void
.end method
