.class Lcom/livemixtapes/Mixtape$21;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->showGuestWarning()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$21;->this$0:Lcom/livemixtapes/Mixtape;

    .line 1532
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 1534
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 1535
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$21;->this$0:Lcom/livemixtapes/Mixtape;

    new-instance v1, Landroid/content/Intent;

    sget-object v2, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-class v3, Lcom/livemixtapes/SignUp;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/livemixtapes/Mixtape;->startActivity(Landroid/content/Intent;)V

    .line 1536
    return-void
.end method
