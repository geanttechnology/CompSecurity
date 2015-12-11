.class public final Lcom/jakewharton/DiskLruCache$Snapshot;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jakewharton/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Snapshot"
.end annotation


# instance fields
.field private final ins:[Ljava/io/InputStream;

.field private final key:Ljava/lang/String;

.field private final lengths:[J

.field private final sequenceNumber:J

.field final synthetic this$0:Lcom/jakewharton/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[J)V
    .locals 1
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "sequenceNumber"    # J
    .param p5, "ins"    # [Ljava/io/InputStream;
    .param p6, "lengths"    # [J

    .prologue
    .line 651
    iput-object p1, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->this$0:Lcom/jakewharton/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 652
    iput-object p2, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->key:Ljava/lang/String;

    .line 653
    iput-wide p3, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->sequenceNumber:J

    .line 654
    iput-object p5, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .line 655
    iput-object p6, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->lengths:[J

    .line 656
    return-void
.end method

.method synthetic constructor <init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/jakewharton/DiskLruCache$1;)V
    .locals 1
    .param p1, "x0"    # Lcom/jakewharton/DiskLruCache;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # J
    .param p5, "x3"    # [Ljava/io/InputStream;
    .param p6, "x4"    # [J
    .param p7, "x5"    # Lcom/jakewharton/DiskLruCache$1;

    .prologue
    .line 645
    invoke-direct/range {p0 .. p6}, Lcom/jakewharton/DiskLruCache$Snapshot;-><init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[J)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    .line 689
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .local v0, "arr$":[Ljava/io/InputStream;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v2, v0, v1

    .line 690
    .local v2, "in":Ljava/io/InputStream;
    invoke-static {v2}, Lcom/jakewharton/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 689
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 692
    .end local v2    # "in":Ljava/io/InputStream;
    :cond_0
    return-void
.end method

.method public getInputStream(I)Ljava/io/InputStream;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 671
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    aget-object v0, v0, p1

    return-object v0
.end method
