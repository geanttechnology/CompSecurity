.class Lio/branch/referral/ApkParser;
.super Ljava/lang/Object;
.source "ApkParser.java"


# static fields
.field public static endDocTag:I

.field public static endTag:I

.field public static startTag:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const v0, 0x100101

    sput v0, Lio/branch/referral/ApkParser;->endDocTag:I

    .line 25
    const v0, 0x100102

    sput v0, Lio/branch/referral/ApkParser;->startTag:I

    .line 31
    const v0, 0x100103

    sput v0, Lio/branch/referral/ApkParser;->endTag:I

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private validURI(Ljava/lang/String;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 166
    if-eqz p1, :cond_0

    .line 167
    const-string v0, "http"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "https"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "geo"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "*"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "package"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "sms"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "smsto"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "mms"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "mmsto"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "tel"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "voicemail"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "file"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "content"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "mailto"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 181
    const/4 v0, 0x1

    .line 184
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public LEW([BI)I
    .locals 3
    .param p1, "arr"    # [B
    .param p2, "off"    # I

    .prologue
    .line 236
    add-int/lit8 v0, p2, 0x3

    aget-byte v0, p1, v0

    shl-int/lit8 v0, v0, 0x18

    const/high16 v1, -0x1000000

    and-int/2addr v0, v1

    add-int/lit8 v1, p2, 0x2

    aget-byte v1, p1, v1

    shl-int/lit8 v1, v1, 0x10

    const/high16 v2, 0xff0000

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    add-int/lit8 v1, p2, 0x1

    aget-byte v1, p1, v1

    shl-int/lit8 v1, v1, 0x8

    const v2, 0xff00

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    aget-byte v1, p1, p2

    and-int/lit16 v1, v1, 0xff

    or-int/2addr v0, v1

    return v0
.end method

.method public compXmlString([BIII)Ljava/lang/String;
    .locals 2
    .param p1, "xml"    # [B
    .param p2, "sitOff"    # I
    .param p3, "stOff"    # I
    .param p4, "strInd"    # I

    .prologue
    .line 201
    if-gez p4, :cond_0

    const/4 v1, 0x0

    .line 203
    :goto_0
    return-object v1

    .line 202
    :cond_0
    mul-int/lit8 v1, p4, 0x4

    add-int/2addr v1, p2

    invoke-virtual {p0, p1, v1}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v1

    add-int v0, p3, v1

    .line 203
    .local v0, "strOff":I
    invoke-virtual {p0, p1, v0}, Lio/branch/referral/ApkParser;->compXmlStringAt([BI)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public compXmlStringAt([BI)Ljava/lang/String;
    .locals 5
    .param p1, "arr"    # [B
    .param p2, "strOff"    # I

    .prologue
    .line 215
    add-int/lit8 v3, p2, 0x1

    aget-byte v3, p1, v3

    shl-int/lit8 v3, v3, 0x8

    const v4, 0xff00

    and-int/2addr v3, v4

    aget-byte v4, p1, p2

    and-int/lit16 v4, v4, 0xff

    or-int v2, v3, v4

    .line 216
    .local v2, "strLen":I
    new-array v0, v2, [B

    .line 217
    .local v0, "chars":[B
    const/4 v1, 0x0

    .local v1, "ii":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 218
    add-int/lit8 v3, p2, 0x2

    mul-int/lit8 v4, v1, 0x2

    add-int/2addr v3, v4

    aget-byte v3, p1, v3

    aput-byte v3, v0, v1

    .line 217
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 220
    :cond_0
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v0}, Ljava/lang/String;-><init>([B)V

    return-object v3
.end method

.method public decompressXML([B)Ljava/lang/String;
    .locals 17
    .param p1, "xml"    # [B

    .prologue
    .line 58
    const/16 v15, 0x10

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v9

    .line 62
    .local v9, "numbStrings":I
    const/16 v11, 0x24

    .line 66
    .local v11, "sitOff":I
    mul-int/lit8 v15, v9, 0x4

    add-int v12, v11, v15

    .line 71
    .local v12, "stOff":I
    const/16 v15, 0xc

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v14

    .line 73
    .local v14, "xmlTagOff":I
    move v7, v14

    .local v7, "ii":I
    :goto_0
    move-object/from16 v0, p1

    array-length v15, v0

    add-int/lit8 v15, v15, -0x4

    if-ge v7, v15, :cond_0

    .line 74
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v7}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v15

    sget v16, Lio/branch/referral/ApkParser;->startTag:I

    move/from16 v0, v16

    if-ne v15, v0, :cond_2

    .line 75
    move v14, v7

    .line 104
    :cond_0
    move v10, v14

    .line 105
    .local v10, "off":I
    :cond_1
    :goto_1
    move-object/from16 v0, p1

    array-length v15, v0

    if-ge v10, v15, :cond_7

    .line 106
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v10}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v13

    .line 107
    .local v13, "tag0":I
    sget v15, Lio/branch/referral/ApkParser;->startTag:I

    if-ne v13, v15, :cond_5

    .line 108
    add-int/lit8 v15, v10, 0x1c

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v8

    .line 109
    .local v8, "numbAttrs":I
    add-int/lit8 v10, v10, 0x24

    .line 111
    const/4 v7, 0x0

    :goto_2
    if-ge v7, v8, :cond_1

    .line 112
    add-int/lit8 v15, v10, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v3

    .line 113
    .local v3, "attrNameSi":I
    add-int/lit8 v15, v10, 0x8

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v6

    .line 114
    .local v6, "attrValueSi":I
    add-int/lit8 v15, v10, 0x10

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lio/branch/referral/ApkParser;->LEW([BI)I

    move-result v4

    .line 115
    .local v4, "attrResId":I
    add-int/lit8 v10, v10, 0x14

    .line 117
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v11, v12, v3}, Lio/branch/referral/ApkParser;->compXmlString([BIII)Ljava/lang/String;

    move-result-object v2

    .line 118
    .local v2, "attrName":Ljava/lang/String;
    const-string v15, "scheme"

    invoke-virtual {v2, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_4

    .line 119
    const/4 v15, -0x1

    if-eq v6, v15, :cond_3

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v11, v12, v6}, Lio/branch/referral/ApkParser;->compXmlString([BIII)Ljava/lang/String;

    move-result-object v5

    .line 120
    .local v5, "attrValue":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lio/branch/referral/ApkParser;->validURI(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_4

    .line 134
    .end local v2    # "attrName":Ljava/lang/String;
    .end local v3    # "attrNameSi":I
    .end local v4    # "attrResId":I
    .end local v5    # "attrValue":Ljava/lang/String;
    .end local v6    # "attrValueSi":I
    .end local v8    # "numbAttrs":I
    .end local v13    # "tag0":I
    :goto_4
    return-object v5

    .line 73
    .end local v10    # "off":I
    :cond_2
    add-int/lit8 v7, v7, 0x4

    goto :goto_0

    .line 119
    .restart local v2    # "attrName":Ljava/lang/String;
    .restart local v3    # "attrNameSi":I
    .restart local v4    # "attrResId":I
    .restart local v6    # "attrValueSi":I
    .restart local v8    # "numbAttrs":I
    .restart local v10    # "off":I
    .restart local v13    # "tag0":I
    :cond_3
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "resourceID 0x"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-static {v4}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 111
    :cond_4
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 125
    .end local v2    # "attrName":Ljava/lang/String;
    .end local v3    # "attrNameSi":I
    .end local v4    # "attrResId":I
    .end local v6    # "attrValueSi":I
    .end local v8    # "numbAttrs":I
    :cond_5
    sget v15, Lio/branch/referral/ApkParser;->endTag:I

    if-ne v13, v15, :cond_6

    .line 126
    add-int/lit8 v10, v10, 0x18

    goto/16 :goto_1

    .line 127
    :cond_6
    sget v15, Lio/branch/referral/ApkParser;->endDocTag:I

    if-ne v13, v15, :cond_7

    .line 134
    .end local v13    # "tag0":I
    :cond_7
    const-string v5, "bnc_no_value"

    goto :goto_4
.end method
