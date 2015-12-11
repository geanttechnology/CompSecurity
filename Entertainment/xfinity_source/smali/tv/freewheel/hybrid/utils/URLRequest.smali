.class public Ltv/freewheel/hybrid/utils/URLRequest;
.super Ljava/lang/Object;
.source "URLRequest.java"


# instance fields
.field public contentType:Ljava/lang/String;

.field public data:Ljava/lang/String;

.field public delayMs:J

.field public method:I

.field public url:Ljava/lang/String;

.field public userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    const/4 v0, 0x0

    iput v0, p0, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    .line 12
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/hybrid/utils/URLRequest;->delayMs:J

    .line 22
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    .line 23
    iput-object p2, p0, Ltv/freewheel/hybrid/utils/URLRequest;->userAgent:Ljava/lang/String;

    .line 24
    return-void
.end method
