.class public final Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/vandalsoftware/io/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Snapshot"
.end annotation


# instance fields
.field private final ins:[Ljava/io/InputStream;

.field private final paths:[Ljava/lang/String;


# direct methods
.method private constructor <init>([Ljava/io/InputStream;[Ljava/lang/String;)V
    .locals 0
    .param p1, "ins"    # [Ljava/io/InputStream;
    .param p2, "paths"    # [Ljava/lang/String;

    .prologue
    .line 619
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 620
    iput-object p1, p0, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .line 621
    iput-object p2, p0, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->paths:[Ljava/lang/String;

    .line 622
    return-void
.end method

.method synthetic constructor <init>([Ljava/io/InputStream;[Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$1;)V
    .locals 0
    .param p1, "x0"    # [Ljava/io/InputStream;
    .param p2, "x1"    # [Ljava/lang/String;
    .param p3, "x2"    # Lcom/vandalsoftware/io/DiskLruCache$1;

    .prologue
    .line 615
    invoke-direct {p0, p1, p2}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;-><init>([Ljava/io/InputStream;[Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    .line 640
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .local v0, "arr$":[Ljava/io/InputStream;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v2, v0, v1

    .line 641
    .local v2, "in":Ljava/io/InputStream;
    invoke-static {v2}, Lcom/vandalsoftware/io/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 640
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 643
    .end local v2    # "in":Ljava/io/InputStream;
    :cond_0
    return-void
.end method

.method public getInputStream(I)Ljava/io/InputStream;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 628
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getPath(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 635
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->paths:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
