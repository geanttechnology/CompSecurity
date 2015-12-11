.class public Lcom/amazon/mShop/share/SharableAppInfo;
.super Ljava/lang/Object;
.source "SharableAppInfo.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/mShop/share/SharableAppInfo;",
        ">;"
    }
.end annotation


# instance fields
.field private mIcon:Landroid/graphics/drawable/Drawable;

.field private mLabel:Ljava/lang/CharSequence;

.field private mPackageName:Ljava/lang/String;

.field private mPriority:I

.field private mRefTag:Ljava/lang/String;

.field private mResolveInfo:Landroid/content/pm/ResolveInfo;


# direct methods
.method public constructor <init>(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;ILandroid/content/pm/ResolveInfo;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/CharSequence;
    .param p2, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "refTag"    # Ljava/lang/String;
    .param p5, "priority"    # I
    .param p6, "resolveInfo"    # Landroid/content/pm/ResolveInfo;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mLabel:Ljava/lang/CharSequence;

    .line 16
    iput-object p2, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 17
    iput-object p3, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mPackageName:Ljava/lang/String;

    .line 18
    iput-object p4, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mRefTag:Ljava/lang/String;

    .line 19
    iput p5, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mPriority:I

    .line 20
    iput-object p6, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mResolveInfo:Landroid/content/pm/ResolveInfo;

    .line 21
    return-void
.end method


# virtual methods
.method public compareTo(Lcom/amazon/mShop/share/SharableAppInfo;)I
    .locals 2
    .param p1, "other"    # Lcom/amazon/mShop/share/SharableAppInfo;

    .prologue
    .line 25
    iget v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mPriority:I

    iget v1, p1, Lcom/amazon/mShop/share/SharableAppInfo;->mPriority:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 6
    check-cast p1, Lcom/amazon/mShop/share/SharableAppInfo;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/share/SharableAppInfo;->compareTo(Lcom/amazon/mShop/share/SharableAppInfo;)I

    move-result v0

    return v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mIcon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getLabel()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mLabel:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method public getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mRefTag:Ljava/lang/String;

    return-object v0
.end method

.method public getResolveInfo()Landroid/content/pm/ResolveInfo;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mResolveInfo:Landroid/content/pm/ResolveInfo;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/share/SharableAppInfo;->mLabel:Ljava/lang/CharSequence;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
