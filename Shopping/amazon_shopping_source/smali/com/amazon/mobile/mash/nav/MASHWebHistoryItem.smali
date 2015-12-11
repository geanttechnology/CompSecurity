.class public Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
.super Ljava/lang/Object;
.source "MASHWebHistoryItem.java"


# instance fields
.field private mBookmark:Ljava/lang/String;

.field private mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "bookmark"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->mUrl:Ljava/lang/String;

    .line 34
    iput-object p2, p0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->mBookmark:Ljava/lang/String;

    .line 35
    return-void
.end method


# virtual methods
.method public getBookmark()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->mBookmark:Ljava/lang/String;

    return-object v0
.end method

.method public setBookmark(Ljava/lang/String;)V
    .locals 0
    .param p1, "bookmark"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->mBookmark:Ljava/lang/String;

    .line 50
    return-void
.end method
