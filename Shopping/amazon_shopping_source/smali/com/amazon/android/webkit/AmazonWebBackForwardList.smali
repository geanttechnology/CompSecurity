.class public Lcom/amazon/android/webkit/AmazonWebBackForwardList;
.super Ljava/lang/Object;
.source "AmazonWebBackForwardList.java"


# instance fields
.field private final currentItemIndex:I

.field private final historyItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/android/webkit/AmazonWebHistoryItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;I)V
    .locals 0
    .param p2, "currentIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/android/webkit/AmazonWebHistoryItem;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/android/webkit/AmazonWebHistoryItem;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebBackForwardList;->historyItems:Ljava/util/List;

    .line 29
    iput p2, p0, Lcom/amazon/android/webkit/AmazonWebBackForwardList;->currentItemIndex:I

    .line 30
    return-void
.end method
