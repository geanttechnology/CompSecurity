.class public abstract Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
.super Ljava/lang/Object;
.source "ContentProviderDelegateBase.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/content/ContentProvider;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final mProviderProxy:Landroid/content/ContentProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/ContentProvider;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;, "Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase<TT;>;"
    .local p1, "providerProxy":Landroid/content/ContentProvider;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->mProviderProxy:Landroid/content/ContentProvider;

    .line 13
    return-void
.end method


# virtual methods
.method public abstract delete_impl(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
.end method

.method public getProxy()Landroid/content/ContentProvider;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;, "Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->mProviderProxy:Landroid/content/ContentProvider;

    return-object v0
.end method

.method public abstract getType_impl(Landroid/net/Uri;)Ljava/lang/String;
.end method

.method public abstract insert_impl(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
.end method

.method public abstract query_impl(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
.end method

.method public abstract update_impl(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
.end method
