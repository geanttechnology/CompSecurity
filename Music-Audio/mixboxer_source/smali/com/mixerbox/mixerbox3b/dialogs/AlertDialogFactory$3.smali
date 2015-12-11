.class final Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$3;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 54
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 55
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$3;->val$activity:Landroid/app/Activity;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->cancelUpdate()V

    .line 56
    return-void
.end method
