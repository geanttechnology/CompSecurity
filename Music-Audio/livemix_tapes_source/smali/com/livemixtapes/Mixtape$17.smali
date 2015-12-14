.class Lcom/livemixtapes/Mixtape$17;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->likeMixtape()V
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
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    iput-object p2, p0, Lcom/livemixtapes/Mixtape$17;->val$dialog:Landroid/app/ProgressDialog;

    .line 1376
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 2

    .prologue
    .line 1394
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$37(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V

    .line 1395
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$17;->val$dialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 1396
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 1390
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 1389
    aput-object p1, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 5
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    const/4 v4, 0x1

    .line 1385
    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 1379
    aput-object p1, v1, v2

    aput-object p2, v1, v4

    const/4 v2, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1380
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    # invokes: Lcom/livemixtapes/Mixtape;->disableVoteButtons()V
    invoke-static {v1}, Lcom/livemixtapes/Mixtape;->access$34(Lcom/livemixtapes/Mixtape;)V

    .line 1381
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/livemixtapes/Mixtape;->access$35(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V

    .line 1383
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v2, "score"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1384
    .local v0, "oldScore":I
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$17;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->score:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape;->access$36(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v1

    add-int/lit8 v2, v0, 0x1

    invoke-static {v2}, Lcom/livemixtapes/Utils;->formatWithCommas(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method
