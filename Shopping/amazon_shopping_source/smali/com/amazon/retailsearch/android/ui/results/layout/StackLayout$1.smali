.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->saveUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

.field final synthetic val$asin:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 278
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;->val$asin:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public match(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 282
    instance-of v0, p1, Lcom/amazon/searchapp/retailsearch/model/Product;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;->val$asin:Ljava/lang/String;

    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/Product;

    .end local p1    # "object":Ljava/lang/Object;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
