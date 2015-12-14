.class final Lcom/livemixtapes/AsyncHttp$HttpResponseData;
.super Ljava/lang/Object;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/AsyncHttp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "HttpResponseData"
.end annotation


# instance fields
.field public data:Ljava/lang/String;

.field public exception:Ljava/lang/Exception;

.field public reasonPhrase:Ljava/lang/String;

.field public statusCode:I


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const-string v0, ""

    iput-object v0, p0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->data:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->reasonPhrase:Ljava/lang/String;

    .line 49
    const/4 v0, 0x0

    iput v0, p0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->statusCode:I

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->exception:Ljava/lang/Exception;

    .line 47
    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/AsyncHttp$HttpResponseData;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$HttpResponseData;-><init>()V

    return-void
.end method
