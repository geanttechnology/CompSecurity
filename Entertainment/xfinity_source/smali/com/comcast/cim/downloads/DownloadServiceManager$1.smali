.class Lcom/comcast/cim/downloads/DownloadServiceManager$1;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;-><init>(Landroid/app/Application;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/downloads/DownloadFileFactory;Lcom/comcast/cim/model/user/UserManager;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/SharedPreferences;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 123
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$1;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public connected()V
    .locals 4

    .prologue
    .line 126
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$1;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Initial connection to virtuoso service established"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 129
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->setupServiceSettings()V
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$100(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    .line 130
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->fetchFileList()V
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$200(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Service settings setup & fetchFileList called"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 139
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onDownloadServiceConnected()V

    .line 140
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v2, v3}, Lcom/comcast/cim/model/user/UserManager;->addUserManagerListener(Lcom/comcast/cim/model/user/UserManager$UserManagerListener;)V

    .line 143
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v1

    .line 144
    .local v1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    if-nez v1, :cond_0

    .line 145
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserLoggedOut()V

    .line 149
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->startWatchingExternalStorage()V
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$400(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    .line 150
    .end local v1    # "user":Lcom/comcast/cim/model/user/User;, "TT;"
    :goto_1
    return-void

    .line 131
    :catch_0
    move-exception v0

    .line 134
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "ServiceException while setting up in connected() callback"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 147
    .end local v0    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    .restart local v1    # "user":Lcom/comcast/cim/model/user/User;, "TT;"
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$1;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->userManager:Lcom/comcast/cim/model/user/UserManager;
    invoke-static {v3}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/comcast/cim/model/user/UserManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/model/user/UserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    goto :goto_0
.end method
