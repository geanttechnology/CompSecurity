.class public Lcom/adobe/mediacore/info/Profile;
.super Ljava/lang/Object;


# instance fields
.field private final _bitrate:I

.field private final _height:I

.field private final _width:I


# direct methods
.method public constructor <init>(III)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/info/Profile;->_bitrate:I

    iput p2, p0, Lcom/adobe/mediacore/info/Profile;->_width:I

    iput p3, p0, Lcom/adobe/mediacore/info/Profile;->_height:I

    return-void
.end method


# virtual methods
.method public getBitrate()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/info/Profile;->_bitrate:I

    return v0
.end method

.method public getHeight()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/info/Profile;->_height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/info/Profile;->_width:I

    return v0
.end method
