.class public Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryId:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private link:Lcom/bestbuy/android/api/lib/models/pdp/Link;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/bestbuy/android/api/lib/models/pdp/Link;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->link:Lcom/bestbuy/android/api/lib/models/pdp/Link;

    return-object v0
.end method

.method public setCategoryId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->categoryId:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->displayName:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setLink(Lcom/bestbuy/android/api/lib/models/pdp/Link;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->link:Lcom/bestbuy/android/api/lib/models/pdp/Link;

    .line 39
    return-void
.end method
