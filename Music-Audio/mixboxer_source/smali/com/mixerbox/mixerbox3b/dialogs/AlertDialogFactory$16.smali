.class final Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$16;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 207
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 208
    return-void
.end method
