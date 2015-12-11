.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$3;
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
    .line 418
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$3;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 420
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 421
    return-void
.end method
