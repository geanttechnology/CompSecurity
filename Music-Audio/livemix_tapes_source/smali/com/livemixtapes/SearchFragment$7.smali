.class Lcom/livemixtapes/SearchFragment$7;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "SearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SearchFragment;->loadSearchResults(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$7;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 275
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 2

    .prologue
    .line 288
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$7;->this$0:Lcom/livemixtapes/SearchFragment;

    const/4 v1, 0x0

    # invokes: Lcom/livemixtapes/SearchFragment;->updateUI(Z)V
    invoke-static {v0, v1}, Lcom/livemixtapes/SearchFragment;->access$3(Lcom/livemixtapes/SearchFragment;Z)V

    .line 289
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 283
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 284
    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    .line 278
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$7;->this$0:Lcom/livemixtapes/SearchFragment;

    # invokes: Lcom/livemixtapes/SearchFragment;->loadSearchResultsFromJson(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/livemixtapes/SearchFragment;->access$4(Lcom/livemixtapes/SearchFragment;Ljava/lang/String;)V

    .line 279
    return-void
.end method
