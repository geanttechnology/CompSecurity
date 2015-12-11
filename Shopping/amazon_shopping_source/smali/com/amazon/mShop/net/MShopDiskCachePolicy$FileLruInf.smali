.class public Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
.super Ljava/lang/Object;
.source "MShopDiskCachePolicy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MShopDiskCachePolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileLruInf"
.end annotation


# static fields
.field public static final COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public mCanonicalPath:Ljava/lang/String;

.field public mFile:Ljava/io/File;

.field public mFileName:Ljava/lang/String;

.field public mInfFile:Ljava/lang/String;

.field public mLastModifiedTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/lang/String;)V
    .locals 2
    .param p1, "f"    # Ljava/io/File;
    .param p2, "canonicalPath"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFileName:Ljava/lang/String;

    .line 39
    iput-object p1, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFile:Ljava/io/File;

    .line 40
    invoke-virtual {p1}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mLastModifiedTime:J

    .line 41
    iput-object p2, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mCanonicalPath:Ljava/lang/String;

    .line 42
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mCanonicalPath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".inf"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mInfFile:Ljava/lang/String;

    .line 43
    return-void
.end method
