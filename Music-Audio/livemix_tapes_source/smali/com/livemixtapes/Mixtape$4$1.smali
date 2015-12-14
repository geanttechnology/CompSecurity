.class Lcom/livemixtapes/Mixtape$4$1;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/Mixtape$4;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape$4;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$4$1;->this$1:Lcom/livemixtapes/Mixtape$4;

    .line 350
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 352
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/livemixtapes/Mixtape$4$1;->this$1:Lcom/livemixtapes/Mixtape$4;

    # getter for: Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$4;->access$0(Lcom/livemixtapes/Mixtape$4;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 353
    const-string v1, "Mixtape Downloading"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 354
    const-string v1, "You already have a mixtape zip downloading...please wait for it to finish."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 355
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/Mixtape$4$1$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtape$4$1$1;-><init>(Lcom/livemixtapes/Mixtape$4$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 365
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 366
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 371
    return-void
.end method
