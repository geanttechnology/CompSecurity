.class Lco/vine/android/util/UrlResourceCache$PendingRes;
.super Ljava/lang/Object;
.source "UrlResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/UrlResourceCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PendingRes"
.end annotation


# instance fields
.field final persist:Z

.field final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "persist"    # Z

    .prologue
    .line 301
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 302
    iput-object p1, p0, Lco/vine/android/util/UrlResourceCache$PendingRes;->url:Ljava/lang/String;

    .line 303
    iput-boolean p2, p0, Lco/vine/android/util/UrlResourceCache$PendingRes;->persist:Z

    .line 304
    return-void
.end method
