.class Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;
.super Ljava/lang/Object;
.source "UrlResourceCache.java"

# interfaces
.implements Lco/vine/android/network/HttpOperationReader;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/UrlResourceCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ResourceHttpOperationReader"
.end annotation


# instance fields
.field private final mKey:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TK;"
        }
    .end annotation
.end field

.field private final mOwnerId:J

.field private final mPersist:Z

.field private mResource:Lco/vine/android/util/UrlResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TV;"
        }
    .end annotation
.end field

.field private final mUrl:Ljava/lang/String;

.field final synthetic this$0:Lco/vine/android/util/UrlResourceCache;


# direct methods
.method public constructor <init>(Lco/vine/android/util/UrlResourceCache;JLjava/lang/Object;Ljava/lang/String;Z)V
    .locals 1
    .param p2, "ownerId"    # J
    .param p5, "url"    # Ljava/lang/String;
    .param p6, "persist"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 411
    .local p0, "this":Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>.ResourceHttpOperationReader;"
    .local p4, "key":Ljava/lang/Object;, "TK;"
    iput-object p1, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->this$0:Lco/vine/android/util/UrlResourceCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 409
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mResource:Lco/vine/android/util/UrlResource;

    .line 412
    iput-wide p2, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mOwnerId:J

    .line 413
    iput-object p4, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mKey:Ljava/lang/Object;

    .line 414
    iput-object p5, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mUrl:Ljava/lang/String;

    .line 415
    iput-boolean p6, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mPersist:Z

    .line 416
    return-void
.end method


# virtual methods
.method public final getResultResource()Lco/vine/android/util/UrlResource;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .prologue
    .line 419
    .local p0, "this":Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>.ResourceHttpOperationReader;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mResource:Lco/vine/android/util/UrlResource;

    return-object v0
.end method

.method public onHandleError(Lco/vine/android/network/HttpResult;)V
    .locals 2
    .param p1, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 432
    .local p0, "this":Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>.ResourceHttpOperationReader;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->this$0:Lco/vine/android/util/UrlResourceCache;

    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mKey:Ljava/lang/Object;

    invoke-virtual {v0, v1, p1}, Lco/vine/android/util/UrlResourceCache;->onResourceError(Ljava/lang/Object;Lco/vine/android/network/HttpResult;)V

    .line 433
    return-void
.end method

.method public final readInput(IILjava/io/InputStream;)V
    .locals 7
    .param p1, "statusCode"    # I
    .param p2, "contentLength"    # I
    .param p3, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 424
    .local p0, "this":Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>.ResourceHttpOperationReader;"
    iget-boolean v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mPersist:Z

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->this$0:Lco/vine/android/util/UrlResourceCache;

    iget-wide v1, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mOwnerId:J

    iget-object v3, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mKey:Ljava/lang/Object;

    iget-object v4, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mUrl:Ljava/lang/String;

    const/4 v6, 0x1

    move-object v5, p3

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/UrlResourceCache;->saveResource(JLjava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/UrlResource;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mResource:Lco/vine/android/util/UrlResource;

    .line 429
    :goto_0
    return-void

    .line 427
    :cond_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->this$0:Lco/vine/android/util/UrlResourceCache;

    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mKey:Ljava/lang/Object;

    iget-object v2, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, p3}, Lco/vine/android/util/UrlResourceCache;->obtainResource(Ljava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/UrlResource;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;->mResource:Lco/vine/android/util/UrlResource;

    goto :goto_0
.end method
