.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private displayName:Ljava/lang/String;

.field private id:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;->id:I

    return v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;->displayName:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setId(I)V
    .locals 0

    .prologue
    .line 49
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;->id:I

    .line 50
    return-void
.end method
