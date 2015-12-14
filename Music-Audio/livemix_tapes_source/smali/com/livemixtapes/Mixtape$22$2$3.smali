.class Lcom/livemixtapes/Mixtape$22$2$3;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape$22$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/livemixtapes/Mixtape$22$2;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape$22$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$22$2$3;->this$2:Lcom/livemixtapes/Mixtape$22$2;

    .line 1767
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1769
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/livemixtapes/Mixtape$22$2$3;->this$2:Lcom/livemixtapes/Mixtape$22$2;

    # getter for: Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$22$2;->access$0(Lcom/livemixtapes/Mixtape$22$2;)Lcom/livemixtapes/Mixtape$22;

    move-result-object v1

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1770
    const-string v1, "Download Complete"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1771
    const-string v1, "Your mixtape has finished downloading!  We extracted the zip for you too!"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1772
    const-string v1, "Thanks!"

    new-instance v2, Lcom/livemixtapes/Mixtape$22$2$3$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtape$22$2$3$1;-><init>(Lcom/livemixtapes/Mixtape$22$2$3;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1782
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1783
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 1788
    return-void
.end method
