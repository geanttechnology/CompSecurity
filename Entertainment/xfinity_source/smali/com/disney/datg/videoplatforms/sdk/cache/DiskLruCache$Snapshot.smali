.class public final Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Snapshot"
.end annotation


# instance fields
.field private final ins:[Ljava/io/InputStream;

.field private final key:Ljava/lang/String;

.field private final sequenceNumber:J

.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;)V
    .locals 1
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "sequenceNumber"    # J
    .param p5, "ins"    # [Ljava/io/InputStream;

    .prologue
    .line 729
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 730
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->key:Ljava/lang/String;

    .line 731
    iput-wide p3, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->sequenceNumber:J

    .line 732
    iput-object p5, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .line 733
    return-void
.end method

.method synthetic constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;)V
    .locals 1
    .param p1, "x0"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # J
    .param p5, "x3"    # [Ljava/io/InputStream;
    .param p6, "x4"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;

    .prologue
    .line 724
    invoke-direct/range {p0 .. p5}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;-><init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    .line 759
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .local v0, "arr$":[Ljava/io/InputStream;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v2, v0, v1

    .line 760
    .local v2, "in":Ljava/io/InputStream;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 759
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 762
    .end local v2    # "in":Ljava/io/InputStream;
    :cond_0
    return-void
.end method

.method public getInputStream(I)Ljava/io/InputStream;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 748
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    aget-object v0, v0, p1

    return-object v0
.end method
