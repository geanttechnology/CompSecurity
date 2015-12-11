.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;
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
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;->id:I

    return v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;->displayName:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setId(I)V
    .locals 0

    .prologue
    .line 44
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;->id:I

    .line 45
    return-void
.end method
