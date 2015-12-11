.class final Lcom/adobe/mediacore/AdHandle;
.super Ljava/lang/Object;


# instance fields
.field private final _duration:J

.field private final _handle:I


# direct methods
.method public constructor <init>(IJ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/AdHandle;->_handle:I

    iput-wide p2, p0, Lcom/adobe/mediacore/AdHandle;->_duration:J

    return-void
.end method


# virtual methods
.method public getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/AdHandle;->_duration:J

    return-wide v0
.end method

.method public getHandle()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/AdHandle;->_handle:I

    return v0
.end method
