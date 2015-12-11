.class public Lcom/adobe/mediacore/AdTimeline$AdInformation;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/AdTimeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AdInformation"
.end annotation


# instance fields
.field private final _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private final _progress:I


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/AdTimeline$AdInformation;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput p2, p0, Lcom/adobe/mediacore/AdTimeline$AdInformation;->_progress:I

    return-void
.end method


# virtual methods
.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline$AdInformation;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getProgress()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/AdTimeline$AdInformation;->_progress:I

    return v0
.end method
