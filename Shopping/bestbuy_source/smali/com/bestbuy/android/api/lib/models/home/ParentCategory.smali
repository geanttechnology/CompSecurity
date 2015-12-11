.class public Lcom/bestbuy/android/api/lib/models/home/ParentCategory;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x7e2f3bc96ee7e750L


# instance fields
.field private categoryId:Ljava/lang/String;

.field private displayName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ParentCategory;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ParentCategory;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ParentCategory;->categoryId:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ParentCategory;->displayName:Ljava/lang/String;

    .line 36
    return-void
.end method
