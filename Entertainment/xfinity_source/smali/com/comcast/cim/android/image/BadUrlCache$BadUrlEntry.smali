.class Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
.super Ljava/lang/Object;
.source "BadUrlCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/image/BadUrlCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BadUrlEntry"
.end annotation


# instance fields
.field expirationTime:J

.field final synthetic this$0:Lcom/comcast/cim/android/image/BadUrlCache;

.field final url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/image/BadUrlCache;Ljava/lang/String;J)V
    .locals 1
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "expirationTime"    # J

    .prologue
    .line 27
    iput-object p1, p0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->this$0:Lcom/comcast/cim/android/image/BadUrlCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p2, p0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->url:Ljava/lang/String;

    .line 29
    iput-wide p3, p0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->expirationTime:J

    .line 30
    return-void
.end method
