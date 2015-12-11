.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    .prologue
    .line 412
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 415
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1800(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1700(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 416
    return-void
.end method
