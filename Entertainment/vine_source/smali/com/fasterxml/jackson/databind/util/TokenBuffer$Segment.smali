.class public final Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
.super Ljava/lang/Object;
.source "TokenBuffer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/util/TokenBuffer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "Segment"
.end annotation


# static fields
.field public static final TOKENS_PER_SEGMENT:I = 0x10

.field private static final TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;


# instance fields
.field protected _nativeIds:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected _next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

.field protected _tokenTypes:J

.field protected final _tokens:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 1525
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/fasterxml/jackson/core/JsonToken;

    sput-object v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    .line 1526
    invoke-static {}, Lcom/fasterxml/jackson/core/JsonToken;->values()[Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1528
    sget-object v1, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    const/16 v2, 0xf

    array-length v3, v0

    add-int/lit8 v3, v3, -0x1

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {v0, v4, v1, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1529
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 1553
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1546
    const/16 v0, 0x10

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    .line 1553
    return-void
.end method

.method private final _objectIdIndex(I)I
    .locals 1

    .prologue
    .line 1758
    add-int v0, p1, p1

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private final _typeIdIndex(I)I
    .locals 1

    .prologue
    .line 1757
    add-int v0, p1, p1

    return v0
.end method

.method private final assignNativeIds(ILjava/lang/Object;Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 1732
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    if-nez v0, :cond_0

    .line 1733
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    .line 1735
    :cond_0
    if-eqz p2, :cond_1

    .line 1736
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_objectIdIndex(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1738
    :cond_1
    if-eqz p3, :cond_2

    .line 1739
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_typeIdIndex(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p3}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1741
    :cond_2
    return-void
.end method

.method private set(IILjava/lang/Object;)V
    .locals 4

    .prologue
    .line 1709
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v0, p1

    .line 1710
    int-to-long v0, p2

    .line 1711
    if-lez p1, :cond_0

    .line 1712
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1714
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1715
    return-void
.end method

.method private set(IILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 1720
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v0, p1

    .line 1721
    int-to-long v0, p2

    .line 1722
    if-lez p1, :cond_0

    .line 1723
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1725
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1726
    invoke-direct {p0, p1, p4, p5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->assignNativeIds(ILjava/lang/Object;Ljava/lang/Object;)V

    .line 1727
    return-void
.end method

.method private set(ILcom/fasterxml/jackson/core/JsonToken;)V
    .locals 4

    .prologue
    .line 1667
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v0

    int-to-long v0, v0

    .line 1668
    if-lez p1, :cond_0

    .line 1669
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1671
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1672
    return-void
.end method

.method private set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 1687
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v0, p1

    .line 1688
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v0

    int-to-long v0, v0

    .line 1689
    if-lez p1, :cond_0

    .line 1690
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1692
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1693
    return-void
.end method

.method private set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 1677
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v0

    int-to-long v0, v0

    .line 1678
    if-lez p1, :cond_0

    .line 1679
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1681
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1682
    invoke-direct {p0, p1, p3, p4}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->assignNativeIds(ILjava/lang/Object;Ljava/lang/Object;)V

    .line 1683
    return-void
.end method

.method private set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 1698
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v0, p1

    .line 1699
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v0

    int-to-long v0, v0

    .line 1700
    if-lez p1, :cond_0

    .line 1701
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1703
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1704
    invoke-direct {p0, p1, p4, p5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->assignNativeIds(ILjava/lang/Object;Ljava/lang/Object;)V

    .line 1705
    return-void
.end method


# virtual methods
.method public append(ILcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2

    .prologue
    .line 1595
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1596
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;)V

    .line 1597
    const/4 v0, 0x0

    .line 1601
    :goto_0
    return-object v0

    .line 1599
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1600
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;)V

    .line 1601
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public append(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2

    .prologue
    .line 1618
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1619
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V

    .line 1620
    const/4 v0, 0x0

    .line 1624
    :goto_0
    return-object v0

    .line 1622
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1623
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V

    .line 1624
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public append(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2

    .prologue
    .line 1607
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1608
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1609
    const/4 v0, 0x0

    .line 1613
    :goto_0
    return-object v0

    .line 1611
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1612
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1613
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public append(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 6

    .prologue
    .line 1630
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1631
    invoke-direct/range {p0 .. p5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1632
    const/4 v0, 0x0

    .line 1636
    :goto_0
    return-object v0

    .line 1634
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1635
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1636
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public appendRaw(IILjava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2

    .prologue
    .line 1641
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1642
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;)V

    .line 1643
    const/4 v0, 0x0

    .line 1647
    :goto_0
    return-object v0

    .line 1645
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1646
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;)V

    .line 1647
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public appendRaw(IILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 6

    .prologue
    .line 1653
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1654
    invoke-direct/range {p0 .. p5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1655
    const/4 v0, 0x0

    .line 1659
    :goto_0
    return-object v0

    .line 1657
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1658
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1659
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public findObjectId(I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 1747
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_objectIdIndex(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public findTypeId(I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 1754
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_typeIdIndex(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public get(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1578
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public hasIds()Z
    .locals 1

    .prologue
    .line 1588
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_nativeIds:Ljava/util/TreeMap;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public next()Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 1

    .prologue
    .line 1581
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    return-object v0
.end method

.method public rawType(I)I
    .locals 3

    .prologue
    .line 1569
    iget-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1570
    if-lez p1, :cond_0

    .line 1571
    shl-int/lit8 v2, p1, 0x2

    shr-long/2addr v0, v2

    .line 1573
    :cond_0
    long-to-int v0, v0

    and-int/lit8 v0, v0, 0xf

    .line 1574
    return v0
.end method

.method public type(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 3

    .prologue
    .line 1559
    iget-wide v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1560
    if-lez p1, :cond_0

    .line 1561
    shl-int/lit8 v2, p1, 0x2

    shr-long/2addr v0, v2

    .line 1563
    :cond_0
    long-to-int v0, v0

    and-int/lit8 v0, v0, 0xf

    .line 1564
    sget-object v1, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    aget-object v0, v1, v0

    return-object v0
.end method
