.class public Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;
.super Ljava/lang/Object;
.source "FastBrowseItem.java"


# instance fields
.field private browseUrl:Ljava/lang/String;

.field private icon:I

.field private title:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "browseUrl"    # Ljava/lang/String;
    .param p4, "icon"    # I

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->title:Ljava/lang/String;

    .line 29
    iput-object p2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->url:Ljava/lang/String;

    .line 30
    iput p4, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->icon:I

    .line 31
    iput-object p3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->browseUrl:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method public getBrowseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->browseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->icon:I

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setBrowseUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "browseUrl"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->browseUrl:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setIcon(I)V
    .locals 0
    .param p1, "icon"    # I

    .prologue
    .line 71
    iput p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->icon:I

    .line 72
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->title:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->url:Ljava/lang/String;

    .line 62
    return-void
.end method
