.class public Lcom/adobe/mediacore/metadata/BlackoutMetadata;
.super Lcom/adobe/mediacore/metadata/MetadataNode;


# instance fields
.field private _nonSeekableRanges:[Lcom/adobe/mediacore/utils/TimeRange;


# direct methods
.method public constructor <init>([Lcom/adobe/mediacore/utils/TimeRange;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/metadata/BlackoutMetadata;->_nonSeekableRanges:[Lcom/adobe/mediacore/utils/TimeRange;

    return-void
.end method


# virtual methods
.method public getNonSeekableRanges()[Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/BlackoutMetadata;->_nonSeekableRanges:[Lcom/adobe/mediacore/utils/TimeRange;

    return-object v0
.end method
