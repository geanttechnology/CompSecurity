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
.field protected _next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

.field protected _tokenTypes:J

.field protected final _tokens:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 1208
    const/16 v1, 0x10

    new-array v1, v1, [Lcom/fasterxml/jackson/core/JsonToken;

    sput-object v1, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    .line 1209
    invoke-static {}, Lcom/fasterxml/jackson/core/JsonToken;->values()[Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1210
    .local v0, "t":[Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v1, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    const/16 v2, 0xf

    array-length v3, v0

    add-int/lit8 v3, v3, -0x1

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {v0, v4, v1, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1211
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 1230
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1228
    const/16 v0, 0x10

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    .line 1230
    return-void
.end method

.method private set(IILjava/lang/Object;)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "rawTokenType"    # I
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 1322
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v2, p1

    .line 1323
    int-to-long v0, p2

    .line 1324
    .local v0, "typeCode":J
    if-lez p1, :cond_0

    .line 1325
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1327
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v2, v0

    iput-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1328
    return-void
.end method


# virtual methods
.method public append(ILcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2
    .param p1, "index"    # I
    .param p2, "tokenType"    # Lcom/fasterxml/jackson/core/JsonToken;

    .prologue
    .line 1264
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1265
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;)V

    .line 1266
    const/4 v0, 0x0

    .line 1270
    :goto_0
    return-object v0

    .line 1268
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1269
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;)V

    .line 1270
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public append(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2
    .param p1, "index"    # I
    .param p2, "tokenType"    # Lcom/fasterxml/jackson/core/JsonToken;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 1275
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1276
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V

    .line 1277
    const/4 v0, 0x0

    .line 1281
    :goto_0
    return-object v0

    .line 1279
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1280
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V

    .line 1281
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public appendRaw(IILjava/lang/Object;)Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 2
    .param p1, "index"    # I
    .param p2, "rawTokenType"    # I
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 1286
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    .line 1287
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;)V

    .line 1288
    const/4 v0, 0x0

    .line 1292
    :goto_0
    return-object v0

    .line 1290
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    .line 1291
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3}, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->set(IILjava/lang/Object;)V

    .line 1292
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    goto :goto_0
.end method

.method public get(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 1255
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public next()Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;
    .locals 1

    .prologue
    .line 1258
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_next:Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;

    return-object v0
.end method

.method public rawType(I)I
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 1246
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1247
    .local v2, "l":J
    if-lez p1, :cond_0

    .line 1248
    shl-int/lit8 v1, p1, 0x2

    shr-long/2addr v2, v1

    .line 1250
    :cond_0
    long-to-int v1, v2

    and-int/lit8 v0, v1, 0xf

    .line 1251
    .local v0, "ix":I
    return v0
.end method

.method public set(ILcom/fasterxml/jackson/core/JsonToken;)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "tokenType"    # Lcom/fasterxml/jackson/core/JsonToken;

    .prologue
    .line 1300
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v2

    int-to-long v0, v2

    .line 1301
    .local v0, "typeCode":J
    if-lez p1, :cond_0

    .line 1302
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1304
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v2, v0

    iput-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1305
    return-void
.end method

.method public set(ILcom/fasterxml/jackson/core/JsonToken;Ljava/lang/Object;)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "tokenType"    # Lcom/fasterxml/jackson/core/JsonToken;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 1309
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokens:[Ljava/lang/Object;

    aput-object p3, v2, p1

    .line 1310
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v2

    int-to-long v0, v2

    .line 1314
    .local v0, "typeCode":J
    if-lez p1, :cond_0

    .line 1315
    shl-int/lit8 v2, p1, 0x2

    shl-long/2addr v0, v2

    .line 1317
    :cond_0
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    or-long/2addr v2, v0

    iput-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1318
    return-void
.end method

.method public type(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 1236
    iget-wide v2, p0, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->_tokenTypes:J

    .line 1237
    .local v2, "l":J
    if-lez p1, :cond_0

    .line 1238
    shl-int/lit8 v1, p1, 0x2

    shr-long/2addr v2, v1

    .line 1240
    :cond_0
    long-to-int v1, v2

    and-int/lit8 v0, v1, 0xf

    .line 1241
    .local v0, "ix":I
    sget-object v1, Lcom/fasterxml/jackson/databind/util/TokenBuffer$Segment;->TOKEN_TYPES_BY_INDEX:[Lcom/fasterxml/jackson/core/JsonToken;

    aget-object v1, v1, v0

    return-object v1
.end method
