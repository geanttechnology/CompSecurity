.class Lcom/livemixtapes/Mixtape$24;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->unfavoriteMixtape()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;

.field private final synthetic val$dialog:Landroid/app/ProgressDialog;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;Landroid/app/ProgressDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$24;->this$0:Lcom/livemixtapes/Mixtape;

    iput-object p2, p0, Lcom/livemixtapes/Mixtape$24;->val$dialog:Landroid/app/ProgressDialog;

    .line 1894
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 1

    .prologue
    .line 1910
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$24;->val$dialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 1911
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 1906
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 1905
    aput-object p1, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    const/4 v3, 0x0

    .line 1901
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    .line 1897
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "removed: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/livemixtapes/Mixtape$24;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->id:I
    invoke-static {v2}, Lcom/livemixtapes/Mixtape;->access$38(Lcom/livemixtapes/Mixtape;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v3

    const/4 v1, 0x1

    aput-object p1, v0, v1

    const/4 v1, 0x2

    aput-object p2, v0, v1

    const/4 v1, 0x3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1898
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$24;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$40(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageButton;

    move-result-object v0

    const v1, 0x7f0200eb

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 1899
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$24;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$41(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V

    .line 1900
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$24;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->id:I
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$38(Lcom/livemixtapes/Mixtape;)I

    move-result v0

    invoke-static {v0}, Lcom/livemixtapes/User;->removeFavoriteMixtape(I)V

    return-void
.end method
