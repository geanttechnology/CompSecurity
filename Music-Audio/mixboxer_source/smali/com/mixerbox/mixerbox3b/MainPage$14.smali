.class Lcom/mixerbox/mixerbox3b/MainPage$14;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1231
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$14;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 1

    .prologue
    .line 1234
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$14;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    check-cast p2, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    iput-object p2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    .line 1235
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2

    .prologue
    .line 1239
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$14;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    .line 1240
    return-void
.end method
