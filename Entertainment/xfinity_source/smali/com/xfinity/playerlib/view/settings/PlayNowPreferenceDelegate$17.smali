.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$17;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->showUnregisterErrorDialog(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 528
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$17;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 531
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$17;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDevice()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 532
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 533
    return-void
.end method
