.class public Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;
.super Ljava/lang/Object;
.source "EPAdTrackingManager.java"


# static fields
.field protected static final ID3_IDENTIFIER:Ljava/lang/String; = "TIT2"


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mCtx:Landroid/content/Context;

.field private ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/content/Context;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->mActivity:Landroid/app/Activity;

    .line 30
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->mCtx:Landroid/content/Context;

    .line 31
    return-void
.end method

.method protected static extractTIT2Frame([BLjava/lang/String;)Ljava/lang/String;
    .locals 33
    .param p0, "tag"    # [B
    .param p1, "identifyID"    # Ljava/lang/String;

    .prologue
    .line 89
    const/16 v27, 0x0

    .line 90
    .local v27, "text":Ljava/lang/String;
    const/16 v25, 0x0

    .line 93
    .local v25, "offset":I
    const/4 v5, 0x0

    .line 94
    .local v5, "bExtendedHeader":Z
    const/16 v13, 0xa

    .line 96
    .local v13, "frameHeaderSize":I
    move-object/from16 v22, p0

    .line 97
    .local v22, "id3v2":[B
    move-object/from16 v0, v22

    array-length v0, v0

    move/from16 v23, v0

    .line 100
    .local v23, "id3v2Size":I
    new-instance v17, Ljava/lang/String;

    const/16 v30, 0x3

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move/from16 v2, v25

    move/from16 v3, v30

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([BII)V

    .line 101
    .local v17, "id3Head":Ljava/lang/String;
    const-string v30, "ID3"

    move-object/from16 v0, v17

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-nez v30, :cond_0

    .line 102
    const-string v30, "Not ID3 tag"

    const/16 v31, 0x2

    const/16 v32, 0x0

    invoke-static/range {v30 .. v32}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 103
    const/16 v28, 0x0

    .line 211
    :goto_0
    return-object v28

    .line 105
    :cond_0
    add-int/lit8 v25, v25, 0x3

    .line 107
    const/16 v30, 0x2

    move/from16 v0, v30

    new-array v0, v0, [B

    move-object/from16 v21, v0

    .line 108
    .local v21, "id3Version":[B
    const/16 v30, 0x0

    const/16 v31, 0x2

    move-object/from16 v0, v22

    move/from16 v1, v25

    move-object/from16 v2, v21

    move/from16 v3, v30

    move/from16 v4, v31

    invoke-static {v0, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 109
    const/16 v30, 0x0

    aget-byte v30, v21, v30

    const/16 v31, 0x3

    move/from16 v0, v30

    move/from16 v1, v31

    if-gt v0, v1, :cond_3

    .line 110
    const/16 v29, 0x3

    .line 117
    .local v29, "version":I
    :goto_1
    add-int/lit8 v25, v25, 0x2

    .line 119
    aget-byte v18, v22, v25

    .line 120
    .local v18, "id3HeaderFlag":B
    shr-int/lit8 v30, v18, 0x6

    and-int/lit8 v30, v30, 0x1

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_1

    .line 121
    const/4 v5, 0x1

    .line 123
    :cond_1
    add-int/lit8 v25, v25, 0x1

    .line 125
    const/16 v30, 0x4

    move/from16 v0, v30

    new-array v0, v0, [B

    move-object/from16 v20, v0

    .line 126
    .local v20, "id3TagSize":[B
    const/16 v30, 0x0

    const/16 v31, 0x4

    move-object/from16 v0, v22

    move/from16 v1, v25

    move-object/from16 v2, v20

    move/from16 v3, v30

    move/from16 v4, v31

    invoke-static {v0, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 127
    const/16 v30, 0x0

    aget-byte v30, v20, v30

    and-int/lit8 v30, v30, 0x7f

    const/high16 v31, 0x200000

    mul-int v30, v30, v31

    const/16 v31, 0x1

    aget-byte v31, v20, v31

    and-int/lit8 v31, v31, 0x7f

    move/from16 v0, v31

    mul-int/lit16 v0, v0, 0x400

    move/from16 v31, v0

    add-int v30, v30, v31

    const/16 v31, 0x2

    aget-byte v31, v20, v31

    and-int/lit8 v31, v31, 0x7f

    move/from16 v0, v31

    mul-int/lit16 v0, v0, 0x80

    move/from16 v31, v0

    add-int v30, v30, v31

    const/16 v31, 0x3

    aget-byte v31, v20, v31

    and-int/lit8 v31, v31, 0x7f

    add-int v19, v30, v31

    .line 128
    .local v19, "id3Size":I
    add-int/lit8 v25, v25, 0x4

    .line 130
    if-eqz v5, :cond_d

    .line 131
    const/16 v30, 0x4

    move/from16 v0, v30

    new-array v9, v0, [B

    .line 132
    .local v9, "extendedHeaderSize":[B
    const/16 v30, 0x0

    const/16 v31, 0x4

    move-object/from16 v0, v22

    move/from16 v1, v25

    move/from16 v2, v30

    move/from16 v3, v31

    invoke-static {v0, v1, v9, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 133
    const/16 v30, 0x0

    aget-byte v30, v9, v30

    and-int/lit8 v30, v30, 0x7f

    const/high16 v31, 0x200000

    mul-int v30, v30, v31

    const/16 v31, 0x1

    aget-byte v31, v9, v31

    and-int/lit8 v31, v31, 0x7f

    move/from16 v0, v31

    mul-int/lit16 v0, v0, 0x400

    move/from16 v31, v0

    add-int v30, v30, v31

    const/16 v31, 0x2

    aget-byte v31, v9, v31

    and-int/lit8 v31, v31, 0x7f

    move/from16 v0, v31

    mul-int/lit16 v0, v0, 0x80

    move/from16 v31, v0

    add-int v30, v30, v31

    .line 134
    const/16 v31, 0x3

    aget-byte v31, v9, v31

    and-int/lit8 v31, v31, 0x7f

    .line 133
    add-int v10, v30, v31

    .line 135
    .local v10, "extendedSize":I
    add-int/lit8 v25, v10, 0xa

    .line 136
    sub-int v19, v19, v10

    move-object/from16 v28, v27

    .line 139
    .end local v9    # "extendedHeaderSize":[B
    .end local v10    # "extendedSize":I
    .end local v27    # "text":Ljava/lang/String;
    .local v28, "text":Ljava/lang/String;
    :goto_2
    const/16 v30, 0xa

    move/from16 v0, v19

    move/from16 v1, v30

    if-gt v0, v1, :cond_5

    :cond_2
    move-object/from16 v27, v28

    .line 211
    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto/16 :goto_0

    .line 111
    .end local v18    # "id3HeaderFlag":B
    .end local v19    # "id3Size":I
    .end local v20    # "id3TagSize":[B
    .end local v29    # "version":I
    :cond_3
    const/16 v30, 0x0

    aget-byte v30, v21, v30

    const/16 v31, 0x4

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_4

    .line 112
    const/16 v29, 0x4

    .line 113
    .restart local v29    # "version":I
    goto/16 :goto_1

    .line 114
    .end local v29    # "version":I
    :cond_4
    const-string v30, "version is five or higher, ignore"

    const/16 v31, 0x2

    const/16 v32, 0x0

    invoke-static/range {v30 .. v32}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    move-object/from16 v28, v27

    .line 115
    goto/16 :goto_0

    .line 140
    .end local v27    # "text":Ljava/lang/String;
    .restart local v18    # "id3HeaderFlag":B
    .restart local v19    # "id3Size":I
    .restart local v20    # "id3TagSize":[B
    .restart local v28    # "text":Ljava/lang/String;
    .restart local v29    # "version":I
    :cond_5
    move/from16 v0, v25

    move/from16 v1, v23

    if-ge v0, v1, :cond_2

    .line 144
    const/16 v26, 0x0

    .line 147
    .local v26, "skip":Z
    :try_start_0
    new-instance v14, Ljava/lang/String;

    const/16 v30, 0x4

    const-string v31, "UTF-8"

    move-object/from16 v0, v22

    move/from16 v1, v25

    move/from16 v2, v30

    move-object/from16 v3, v31

    invoke-direct {v14, v0, v1, v2, v3}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    .line 148
    .local v14, "frameID":Ljava/lang/String;
    move-object/from16 v0, p1

    invoke-virtual {v14, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v30

    if-nez v30, :cond_6

    .line 149
    const/16 v26, 0x1

    .line 155
    .end local v14    # "frameID":Ljava/lang/String;
    :cond_6
    :goto_3
    add-int/lit8 v25, v25, 0x4

    .line 157
    const/16 v30, 0x4

    move/from16 v0, v30

    new-array v0, v0, [B

    move-object/from16 v16, v0

    .line 158
    .local v16, "id3FrameSize":[B
    const/16 v30, 0x0

    const/16 v31, 0x4

    move-object/from16 v0, v22

    move/from16 v1, v25

    move-object/from16 v2, v16

    move/from16 v3, v30

    move/from16 v4, v31

    invoke-static {v0, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 159
    const/16 v30, 0x0

    aget-byte v30, v16, v30

    const/high16 v31, 0x1000000

    mul-int v30, v30, v31

    const/16 v31, 0x1

    aget-byte v31, v16, v31

    const/high16 v32, 0x10000

    mul-int v31, v31, v32

    add-int v30, v30, v31

    const/16 v31, 0x2

    aget-byte v31, v16, v31

    move/from16 v0, v31

    mul-int/lit16 v0, v0, 0x100

    move/from16 v31, v0

    add-int v30, v30, v31

    const/16 v31, 0x3

    aget-byte v31, v16, v31

    add-int v15, v30, v31

    .line 160
    .local v15, "frameSize":I
    add-int/lit8 v25, v25, 0x4

    .line 162
    const/16 v30, 0x2

    move/from16 v0, v30

    new-array v12, v0, [B

    .line 163
    .local v12, "frameFlag":[B
    const/16 v30, 0x0

    const/16 v31, 0x2

    move-object/from16 v0, v22

    move/from16 v1, v25

    move/from16 v2, v30

    move/from16 v3, v31

    invoke-static {v0, v1, v12, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 164
    add-int/lit8 v25, v25, 0x2

    .line 166
    if-eqz v26, :cond_7

    .line 167
    add-int v25, v25, v15

    .line 168
    add-int/lit8 v30, v15, 0xa

    sub-int v19, v19, v30

    .line 169
    goto/16 :goto_2

    .line 151
    .end local v12    # "frameFlag":[B
    .end local v15    # "frameSize":I
    .end local v16    # "id3FrameSize":[B
    :catch_0
    move-exception v7

    .line 152
    .local v7, "e1":Ljava/io/UnsupportedEncodingException;
    const-string v30, "UnsupportedEncodingException"

    const/16 v31, 0x5

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_3

    .line 172
    .end local v7    # "e1":Ljava/io/UnsupportedEncodingException;
    .restart local v12    # "frameFlag":[B
    .restart local v15    # "frameSize":I
    .restart local v16    # "id3FrameSize":[B
    :cond_7
    aget-byte v8, v22, v25

    .line 173
    .local v8, "encoding":B
    const/16 v30, 0x3

    move/from16 v0, v30

    if-ne v8, v0, :cond_9

    .line 177
    const/4 v11, 0x0

    .line 178
    .local v11, "extra_frame_length":I
    add-int v30, v25, v15

    add-int/lit8 v24, v30, -0x1

    .line 179
    .local v24, "last":I
    aget-byte v30, v22, v24

    if-eqz v30, :cond_8

    aget-byte v30, v22, v24

    const/16 v31, 0x32

    move/from16 v0, v30

    move/from16 v1, v31

    if-lt v0, v1, :cond_8

    aget-byte v30, v22, v24

    const/16 v31, 0x7e

    move/from16 v0, v30

    move/from16 v1, v31

    if-gt v0, v1, :cond_8

    .line 180
    add-int/lit8 v11, v11, 0x1

    .line 182
    :cond_8
    :try_start_1
    new-instance v27, Ljava/lang/String;

    add-int/lit8 v30, v25, 0x1

    add-int/lit8 v31, v15, -0x2

    add-int v31, v31, v11

    const-string v32, "UTF-8"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    move/from16 v2, v30

    move/from16 v3, v31

    move-object/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    .line 207
    .end local v11    # "extra_frame_length":I
    .end local v24    # "last":I
    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    :goto_4
    add-int v25, v25, v15

    .line 208
    add-int/lit8 v30, v15, 0xa

    sub-int v19, v19, v30

    move-object/from16 v28, v27

    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    goto/16 :goto_2

    .line 183
    .restart local v11    # "extra_frame_length":I
    .restart local v24    # "last":I
    :catch_1
    move-exception v6

    .line 184
    .local v6, "e":Ljava/io/UnsupportedEncodingException;
    const-string v30, "UnsupportedEncodingException"

    const/16 v31, 0x5

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    move-object/from16 v27, v28

    .line 186
    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto :goto_4

    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v11    # "extra_frame_length":I
    .end local v24    # "last":I
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :cond_9
    if-nez v8, :cond_a

    .line 188
    :try_start_2
    new-instance v27, Ljava/lang/String;

    add-int/lit8 v30, v25, 0x1

    add-int/lit8 v31, v15, -0x2

    const-string v32, "ISO-8859-1"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    move/from16 v2, v30

    move/from16 v3, v31

    move-object/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_2

    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto :goto_4

    .line 189
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :catch_2
    move-exception v6

    .line 190
    .restart local v6    # "e":Ljava/io/UnsupportedEncodingException;
    const-string v30, "UnsupportedEncodingException"

    const/16 v31, 0x5

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    move-object/from16 v27, v28

    .line 192
    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto :goto_4

    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :cond_a
    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v8, v0, :cond_b

    .line 194
    :try_start_3
    new-instance v27, Ljava/lang/String;

    add-int/lit8 v30, v25, 0x1

    add-int/lit8 v31, v15, -0x3

    const-string v32, "UTF-16"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    move/from16 v2, v30

    move/from16 v3, v31

    move-object/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_3
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_3 .. :try_end_3} :catch_3

    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto :goto_4

    .line 195
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :catch_3
    move-exception v6

    .line 196
    .restart local v6    # "e":Ljava/io/UnsupportedEncodingException;
    const-string v30, "UnsupportedEncodingException"

    const/16 v31, 0x5

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    move-object/from16 v27, v28

    .line 198
    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto :goto_4

    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :cond_b
    const/16 v30, 0x2

    move/from16 v0, v30

    if-ne v8, v0, :cond_c

    .line 200
    :try_start_4
    new-instance v27, Ljava/lang/String;

    add-int/lit8 v30, v25, 0x1

    add-int/lit8 v31, v15, -0x3

    const-string v32, "UTF-16"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    move/from16 v2, v30

    move/from16 v3, v31

    move-object/from16 v4, v32

    invoke-direct {v0, v1, v2, v3, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_4} :catch_4

    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto/16 :goto_4

    .line 201
    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    :catch_4
    move-exception v6

    .line 202
    .restart local v6    # "e":Ljava/io/UnsupportedEncodingException;
    const-string v30, "UnsupportedEncodingException"

    const/16 v31, 0x5

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_c
    move-object/from16 v27, v28

    .end local v28    # "text":Ljava/lang/String;
    .restart local v27    # "text":Ljava/lang/String;
    goto/16 :goto_4

    .end local v8    # "encoding":B
    .end local v12    # "frameFlag":[B
    .end local v15    # "frameSize":I
    .end local v16    # "id3FrameSize":[B
    .end local v26    # "skip":Z
    :cond_d
    move-object/from16 v28, v27

    .end local v27    # "text":Ljava/lang/String;
    .restart local v28    # "text":Ljava/lang/String;
    goto/16 :goto_2
.end method


# virtual methods
.method public handleMetaData([BLjava/lang/Long;)V
    .locals 6
    .param p1, "tag"    # [B
    .param p2, "timePositionInSeconds"    # Ljava/lang/Long;

    .prologue
    .line 80
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1}, Ljava/lang/String;-><init>([B)V

    .line 81
    .local v0, "id3":Ljava/lang/String;
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    if-eqz v1, :cond_0

    const-string v1, "TIT2"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 82
    const-string v1, "TIT2"

    invoke-static {p1, v1}, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->extractTIT2Frame([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    const-string v2, "TIT2"

    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v1, v2, v0, v4, v5}, Ltv/freewheel/hybrid/StreamStitcherHelper;->handleMetadata(Ljava/lang/String;Ljava/lang/String;J)V

    .line 86
    :cond_0
    return-void
.end method

.method public progressUpdate(Ljava/lang/Long;)V
    .locals 4
    .param p1, "currentTimePositionInSeconds"    # Ljava/lang/Long;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ltv/freewheel/hybrid/StreamStitcherHelper;->handleProgressUpdate(J)V

    .line 67
    :cond_0
    return-void
.end method

.method public start(Ljava/lang/String;)V
    .locals 5
    .param p1, "playbackURL"    # Ljava/lang/String;

    .prologue
    .line 40
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 41
    .local v1, "url":Ljava/net/URL;
    new-instance v2, Ltv/freewheel/hybrid/StreamStitcherHelper;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->mActivity:Landroid/app/Activity;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->mCtx:Landroid/content/Context;

    invoke-direct {v2, v3, v4, v1}, Ltv/freewheel/hybrid/StreamStitcherHelper;-><init>(Landroid/app/Activity;Landroid/content/Context;Ljava/net/URL;)V

    iput-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    .line 42
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/StreamStitcherHelper;->start()V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    .end local v1    # "url":Ljava/net/URL;
    :goto_0
    return-void

    .line 43
    :catch_0
    move-exception v0

    .line 44
    .local v0, "e":Ljava/net/MalformedURLException;
    const-string v2, "Unable to initialize Ad tracking manager"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->ssh:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->stop()V

    .line 54
    :cond_0
    return-void
.end method
