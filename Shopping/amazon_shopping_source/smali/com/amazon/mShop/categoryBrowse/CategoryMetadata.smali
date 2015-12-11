.class public Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
.super Ljava/lang/Object;
.source "CategoryMetadata.java"


# instance fields
.field public searchAlias:Ljava/lang/String;

.field public searchUrl:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->title:Ljava/lang/String;

    .line 17
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchUrl:Ljava/lang/String;

    .line 19
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchAlias:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "alias"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->title:Ljava/lang/String;

    .line 17
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchUrl:Ljava/lang/String;

    .line 19
    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchAlias:Ljava/lang/String;

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->title:Ljava/lang/String;

    .line 26
    iput-object p2, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchUrl:Ljava/lang/String;

    .line 27
    iput-object p3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchAlias:Ljava/lang/String;

    .line 28
    return-void
.end method
