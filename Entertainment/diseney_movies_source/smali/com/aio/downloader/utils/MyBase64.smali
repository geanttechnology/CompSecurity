.class public Lcom/aio/downloader/utils/MyBase64;
.super Ljava/lang/Object;
.source "MyBase64.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/utils/MyBase64$InputStream;,
        Lcom/aio/downloader/utils/MyBase64$OutputStream;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field public static final DECODE:I = 0x0

.field public static final DONT_GUNZIP:I = 0x4

.field public static final DO_BREAK_LINES:I = 0x8

.field public static final ENCODE:I = 0x1

.field private static final EQUALS_SIGN:B = 0x3dt

.field private static final EQUALS_SIGN_ENC:B = -0x1t

.field public static final GZIP:I = 0x2

.field private static final MAX_LINE_LENGTH:I = 0x4c

.field private static final NEW_LINE:B = 0xat

.field public static final NO_OPTIONS:I = 0x0

.field public static final ORDERED:I = 0x20

.field private static final PREFERRED_ENCODING:Ljava/lang/String; = "US-ASCII"

.field public static final URL_SAFE:I = 0x10

.field private static final WHITE_SPACE_ENC:B = -0x5t

.field private static final _ORDERED_ALPHABET:[B

.field private static final _ORDERED_DECODABET:[B

.field private static final _STANDARD_ALPHABET:[B

.field private static final _STANDARD_DECODABET:[B

.field private static final _URL_SAFE_ALPHABET:[B

.field private static final _URL_SAFE_DECODABET:[B


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v1, 0x1

    const/4 v5, -0x5

    const/16 v4, -0x9

    .line 173
    const-class v0, Lcom/aio/downloader/utils/MyBase64;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    .line 241
    const/16 v0, 0x40

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_STANDARD_ALPHABET:[B

    .line 260
    const/16 v0, 0x100

    new-array v0, v0, [B

    const/4 v2, 0x0

    aput-byte v4, v0, v2

    aput-byte v4, v0, v1

    aput-byte v4, v0, v6

    aput-byte v4, v0, v7

    const/4 v2, 0x4

    aput-byte v4, v0, v2

    const/4 v2, 0x5

    aput-byte v4, v0, v2

    const/4 v2, 0x6

    .line 261
    aput-byte v4, v0, v2

    const/4 v2, 0x7

    aput-byte v4, v0, v2

    const/16 v2, 0x8

    aput-byte v4, v0, v2

    const/16 v2, 0x9

    .line 262
    aput-byte v5, v0, v2

    const/16 v2, 0xa

    aput-byte v5, v0, v2

    const/16 v2, 0xb

    .line 263
    aput-byte v4, v0, v2

    const/16 v2, 0xc

    aput-byte v4, v0, v2

    const/16 v2, 0xd

    .line 264
    aput-byte v5, v0, v2

    const/16 v2, 0xe

    .line 265
    aput-byte v4, v0, v2

    const/16 v2, 0xf

    aput-byte v4, v0, v2

    const/16 v2, 0x10

    aput-byte v4, v0, v2

    const/16 v2, 0x11

    aput-byte v4, v0, v2

    const/16 v2, 0x12

    aput-byte v4, v0, v2

    const/16 v2, 0x13

    aput-byte v4, v0, v2

    const/16 v2, 0x14

    aput-byte v4, v0, v2

    const/16 v2, 0x15

    aput-byte v4, v0, v2

    const/16 v2, 0x16

    aput-byte v4, v0, v2

    const/16 v2, 0x17

    aput-byte v4, v0, v2

    const/16 v2, 0x18

    aput-byte v4, v0, v2

    const/16 v2, 0x19

    aput-byte v4, v0, v2

    const/16 v2, 0x1a

    aput-byte v4, v0, v2

    const/16 v2, 0x1b

    .line 267
    aput-byte v4, v0, v2

    const/16 v2, 0x1c

    aput-byte v4, v0, v2

    const/16 v2, 0x1d

    aput-byte v4, v0, v2

    const/16 v2, 0x1e

    aput-byte v4, v0, v2

    const/16 v2, 0x1f

    aput-byte v4, v0, v2

    const/16 v2, 0x20

    .line 268
    aput-byte v5, v0, v2

    const/16 v2, 0x21

    .line 269
    aput-byte v4, v0, v2

    const/16 v2, 0x22

    aput-byte v4, v0, v2

    const/16 v2, 0x23

    aput-byte v4, v0, v2

    const/16 v2, 0x24

    aput-byte v4, v0, v2

    const/16 v2, 0x25

    aput-byte v4, v0, v2

    const/16 v2, 0x26

    aput-byte v4, v0, v2

    const/16 v2, 0x27

    aput-byte v4, v0, v2

    const/16 v2, 0x28

    aput-byte v4, v0, v2

    const/16 v2, 0x29

    aput-byte v4, v0, v2

    const/16 v2, 0x2a

    aput-byte v4, v0, v2

    const/16 v2, 0x2b

    .line 270
    const/16 v3, 0x3e

    aput-byte v3, v0, v2

    const/16 v2, 0x2c

    .line 271
    aput-byte v4, v0, v2

    const/16 v2, 0x2d

    aput-byte v4, v0, v2

    const/16 v2, 0x2e

    aput-byte v4, v0, v2

    const/16 v2, 0x2f

    .line 272
    const/16 v3, 0x3f

    aput-byte v3, v0, v2

    const/16 v2, 0x30

    .line 273
    const/16 v3, 0x34

    aput-byte v3, v0, v2

    const/16 v2, 0x31

    const/16 v3, 0x35

    aput-byte v3, v0, v2

    const/16 v2, 0x32

    const/16 v3, 0x36

    aput-byte v3, v0, v2

    const/16 v2, 0x33

    const/16 v3, 0x37

    aput-byte v3, v0, v2

    const/16 v2, 0x34

    const/16 v3, 0x38

    aput-byte v3, v0, v2

    const/16 v2, 0x35

    const/16 v3, 0x39

    aput-byte v3, v0, v2

    const/16 v2, 0x36

    const/16 v3, 0x3a

    aput-byte v3, v0, v2

    const/16 v2, 0x37

    const/16 v3, 0x3b

    aput-byte v3, v0, v2

    const/16 v2, 0x38

    const/16 v3, 0x3c

    aput-byte v3, v0, v2

    const/16 v2, 0x39

    const/16 v3, 0x3d

    aput-byte v3, v0, v2

    const/16 v2, 0x3a

    .line 274
    aput-byte v4, v0, v2

    const/16 v2, 0x3b

    aput-byte v4, v0, v2

    const/16 v2, 0x3c

    aput-byte v4, v0, v2

    const/16 v2, 0x3d

    .line 275
    const/4 v3, -0x1

    aput-byte v3, v0, v2

    const/16 v2, 0x3e

    .line 276
    aput-byte v4, v0, v2

    const/16 v2, 0x3f

    aput-byte v4, v0, v2

    const/16 v2, 0x40

    aput-byte v4, v0, v2

    const/16 v2, 0x42

    .line 277
    aput-byte v1, v0, v2

    const/16 v2, 0x43

    aput-byte v6, v0, v2

    const/16 v2, 0x44

    aput-byte v7, v0, v2

    const/16 v2, 0x45

    const/4 v3, 0x4

    aput-byte v3, v0, v2

    const/16 v2, 0x46

    const/4 v3, 0x5

    aput-byte v3, v0, v2

    const/16 v2, 0x47

    const/4 v3, 0x6

    aput-byte v3, v0, v2

    const/16 v2, 0x48

    const/4 v3, 0x7

    aput-byte v3, v0, v2

    const/16 v2, 0x49

    const/16 v3, 0x8

    aput-byte v3, v0, v2

    const/16 v2, 0x4a

    const/16 v3, 0x9

    aput-byte v3, v0, v2

    const/16 v2, 0x4b

    const/16 v3, 0xa

    aput-byte v3, v0, v2

    const/16 v2, 0x4c

    const/16 v3, 0xb

    aput-byte v3, v0, v2

    const/16 v2, 0x4d

    const/16 v3, 0xc

    aput-byte v3, v0, v2

    const/16 v2, 0x4e

    const/16 v3, 0xd

    aput-byte v3, v0, v2

    const/16 v2, 0x4f

    .line 279
    const/16 v3, 0xe

    aput-byte v3, v0, v2

    const/16 v2, 0x50

    const/16 v3, 0xf

    aput-byte v3, v0, v2

    const/16 v2, 0x51

    const/16 v3, 0x10

    aput-byte v3, v0, v2

    const/16 v2, 0x52

    const/16 v3, 0x11

    aput-byte v3, v0, v2

    const/16 v2, 0x53

    const/16 v3, 0x12

    aput-byte v3, v0, v2

    const/16 v2, 0x54

    const/16 v3, 0x13

    aput-byte v3, v0, v2

    const/16 v2, 0x55

    const/16 v3, 0x14

    aput-byte v3, v0, v2

    const/16 v2, 0x56

    const/16 v3, 0x15

    aput-byte v3, v0, v2

    const/16 v2, 0x57

    const/16 v3, 0x16

    aput-byte v3, v0, v2

    const/16 v2, 0x58

    const/16 v3, 0x17

    aput-byte v3, v0, v2

    const/16 v2, 0x59

    const/16 v3, 0x18

    aput-byte v3, v0, v2

    const/16 v2, 0x5a

    const/16 v3, 0x19

    aput-byte v3, v0, v2

    const/16 v2, 0x5b

    .line 281
    aput-byte v4, v0, v2

    const/16 v2, 0x5c

    aput-byte v4, v0, v2

    const/16 v2, 0x5d

    aput-byte v4, v0, v2

    const/16 v2, 0x5e

    aput-byte v4, v0, v2

    const/16 v2, 0x5f

    aput-byte v4, v0, v2

    const/16 v2, 0x60

    aput-byte v4, v0, v2

    const/16 v2, 0x61

    .line 282
    const/16 v3, 0x1a

    aput-byte v3, v0, v2

    const/16 v2, 0x62

    const/16 v3, 0x1b

    aput-byte v3, v0, v2

    const/16 v2, 0x63

    const/16 v3, 0x1c

    aput-byte v3, v0, v2

    const/16 v2, 0x64

    const/16 v3, 0x1d

    aput-byte v3, v0, v2

    const/16 v2, 0x65

    const/16 v3, 0x1e

    aput-byte v3, v0, v2

    const/16 v2, 0x66

    const/16 v3, 0x1f

    aput-byte v3, v0, v2

    const/16 v2, 0x67

    const/16 v3, 0x20

    aput-byte v3, v0, v2

    const/16 v2, 0x68

    const/16 v3, 0x21

    aput-byte v3, v0, v2

    const/16 v2, 0x69

    const/16 v3, 0x22

    aput-byte v3, v0, v2

    const/16 v2, 0x6a

    const/16 v3, 0x23

    aput-byte v3, v0, v2

    const/16 v2, 0x6b

    const/16 v3, 0x24

    aput-byte v3, v0, v2

    const/16 v2, 0x6c

    const/16 v3, 0x25

    aput-byte v3, v0, v2

    const/16 v2, 0x6d

    const/16 v3, 0x26

    aput-byte v3, v0, v2

    const/16 v2, 0x6e

    .line 284
    const/16 v3, 0x27

    aput-byte v3, v0, v2

    const/16 v2, 0x6f

    const/16 v3, 0x28

    aput-byte v3, v0, v2

    const/16 v2, 0x70

    const/16 v3, 0x29

    aput-byte v3, v0, v2

    const/16 v2, 0x71

    const/16 v3, 0x2a

    aput-byte v3, v0, v2

    const/16 v2, 0x72

    const/16 v3, 0x2b

    aput-byte v3, v0, v2

    const/16 v2, 0x73

    const/16 v3, 0x2c

    aput-byte v3, v0, v2

    const/16 v2, 0x74

    const/16 v3, 0x2d

    aput-byte v3, v0, v2

    const/16 v2, 0x75

    const/16 v3, 0x2e

    aput-byte v3, v0, v2

    const/16 v2, 0x76

    const/16 v3, 0x2f

    aput-byte v3, v0, v2

    const/16 v2, 0x77

    const/16 v3, 0x30

    aput-byte v3, v0, v2

    const/16 v2, 0x78

    const/16 v3, 0x31

    aput-byte v3, v0, v2

    const/16 v2, 0x79

    const/16 v3, 0x32

    aput-byte v3, v0, v2

    const/16 v2, 0x7a

    const/16 v3, 0x33

    aput-byte v3, v0, v2

    const/16 v2, 0x7b

    .line 286
    aput-byte v4, v0, v2

    const/16 v2, 0x7c

    aput-byte v4, v0, v2

    const/16 v2, 0x7d

    aput-byte v4, v0, v2

    const/16 v2, 0x7e

    aput-byte v4, v0, v2

    const/16 v2, 0x7f

    aput-byte v4, v0, v2

    const/16 v2, 0x80

    .line 287
    aput-byte v4, v0, v2

    const/16 v2, 0x81

    aput-byte v4, v0, v2

    const/16 v2, 0x82

    aput-byte v4, v0, v2

    const/16 v2, 0x83

    aput-byte v4, v0, v2

    const/16 v2, 0x84

    aput-byte v4, v0, v2

    const/16 v2, 0x85

    aput-byte v4, v0, v2

    const/16 v2, 0x86

    aput-byte v4, v0, v2

    const/16 v2, 0x87

    aput-byte v4, v0, v2

    const/16 v2, 0x88

    aput-byte v4, v0, v2

    const/16 v2, 0x89

    aput-byte v4, v0, v2

    const/16 v2, 0x8a

    aput-byte v4, v0, v2

    const/16 v2, 0x8b

    aput-byte v4, v0, v2

    const/16 v2, 0x8c

    .line 289
    aput-byte v4, v0, v2

    const/16 v2, 0x8d

    aput-byte v4, v0, v2

    const/16 v2, 0x8e

    aput-byte v4, v0, v2

    const/16 v2, 0x8f

    aput-byte v4, v0, v2

    const/16 v2, 0x90

    aput-byte v4, v0, v2

    const/16 v2, 0x91

    aput-byte v4, v0, v2

    const/16 v2, 0x92

    aput-byte v4, v0, v2

    const/16 v2, 0x93

    aput-byte v4, v0, v2

    const/16 v2, 0x94

    aput-byte v4, v0, v2

    const/16 v2, 0x95

    aput-byte v4, v0, v2

    const/16 v2, 0x96

    aput-byte v4, v0, v2

    const/16 v2, 0x97

    aput-byte v4, v0, v2

    const/16 v2, 0x98

    aput-byte v4, v0, v2

    const/16 v2, 0x99

    .line 291
    aput-byte v4, v0, v2

    const/16 v2, 0x9a

    aput-byte v4, v0, v2

    const/16 v2, 0x9b

    aput-byte v4, v0, v2

    const/16 v2, 0x9c

    aput-byte v4, v0, v2

    const/16 v2, 0x9d

    aput-byte v4, v0, v2

    const/16 v2, 0x9e

    aput-byte v4, v0, v2

    const/16 v2, 0x9f

    aput-byte v4, v0, v2

    const/16 v2, 0xa0

    aput-byte v4, v0, v2

    const/16 v2, 0xa1

    aput-byte v4, v0, v2

    const/16 v2, 0xa2

    aput-byte v4, v0, v2

    const/16 v2, 0xa3

    aput-byte v4, v0, v2

    const/16 v2, 0xa4

    aput-byte v4, v0, v2

    const/16 v2, 0xa5

    aput-byte v4, v0, v2

    const/16 v2, 0xa6

    .line 293
    aput-byte v4, v0, v2

    const/16 v2, 0xa7

    aput-byte v4, v0, v2

    const/16 v2, 0xa8

    aput-byte v4, v0, v2

    const/16 v2, 0xa9

    aput-byte v4, v0, v2

    const/16 v2, 0xaa

    aput-byte v4, v0, v2

    const/16 v2, 0xab

    aput-byte v4, v0, v2

    const/16 v2, 0xac

    aput-byte v4, v0, v2

    const/16 v2, 0xad

    aput-byte v4, v0, v2

    const/16 v2, 0xae

    aput-byte v4, v0, v2

    const/16 v2, 0xaf

    aput-byte v4, v0, v2

    const/16 v2, 0xb0

    aput-byte v4, v0, v2

    const/16 v2, 0xb1

    aput-byte v4, v0, v2

    const/16 v2, 0xb2

    aput-byte v4, v0, v2

    const/16 v2, 0xb3

    .line 295
    aput-byte v4, v0, v2

    const/16 v2, 0xb4

    aput-byte v4, v0, v2

    const/16 v2, 0xb5

    aput-byte v4, v0, v2

    const/16 v2, 0xb6

    aput-byte v4, v0, v2

    const/16 v2, 0xb7

    aput-byte v4, v0, v2

    const/16 v2, 0xb8

    aput-byte v4, v0, v2

    const/16 v2, 0xb9

    aput-byte v4, v0, v2

    const/16 v2, 0xba

    aput-byte v4, v0, v2

    const/16 v2, 0xbb

    aput-byte v4, v0, v2

    const/16 v2, 0xbc

    aput-byte v4, v0, v2

    const/16 v2, 0xbd

    aput-byte v4, v0, v2

    const/16 v2, 0xbe

    aput-byte v4, v0, v2

    const/16 v2, 0xbf

    aput-byte v4, v0, v2

    const/16 v2, 0xc0

    .line 297
    aput-byte v4, v0, v2

    const/16 v2, 0xc1

    aput-byte v4, v0, v2

    const/16 v2, 0xc2

    aput-byte v4, v0, v2

    const/16 v2, 0xc3

    aput-byte v4, v0, v2

    const/16 v2, 0xc4

    aput-byte v4, v0, v2

    const/16 v2, 0xc5

    aput-byte v4, v0, v2

    const/16 v2, 0xc6

    aput-byte v4, v0, v2

    const/16 v2, 0xc7

    aput-byte v4, v0, v2

    const/16 v2, 0xc8

    aput-byte v4, v0, v2

    const/16 v2, 0xc9

    aput-byte v4, v0, v2

    const/16 v2, 0xca

    aput-byte v4, v0, v2

    const/16 v2, 0xcb

    aput-byte v4, v0, v2

    const/16 v2, 0xcc

    aput-byte v4, v0, v2

    const/16 v2, 0xcd

    .line 299
    aput-byte v4, v0, v2

    const/16 v2, 0xce

    aput-byte v4, v0, v2

    const/16 v2, 0xcf

    aput-byte v4, v0, v2

    const/16 v2, 0xd0

    aput-byte v4, v0, v2

    const/16 v2, 0xd1

    aput-byte v4, v0, v2

    const/16 v2, 0xd2

    aput-byte v4, v0, v2

    const/16 v2, 0xd3

    aput-byte v4, v0, v2

    const/16 v2, 0xd4

    aput-byte v4, v0, v2

    const/16 v2, 0xd5

    aput-byte v4, v0, v2

    const/16 v2, 0xd6

    aput-byte v4, v0, v2

    const/16 v2, 0xd7

    aput-byte v4, v0, v2

    const/16 v2, 0xd8

    aput-byte v4, v0, v2

    const/16 v2, 0xd9

    aput-byte v4, v0, v2

    const/16 v2, 0xda

    .line 301
    aput-byte v4, v0, v2

    const/16 v2, 0xdb

    aput-byte v4, v0, v2

    const/16 v2, 0xdc

    aput-byte v4, v0, v2

    const/16 v2, 0xdd

    aput-byte v4, v0, v2

    const/16 v2, 0xde

    aput-byte v4, v0, v2

    const/16 v2, 0xdf

    aput-byte v4, v0, v2

    const/16 v2, 0xe0

    aput-byte v4, v0, v2

    const/16 v2, 0xe1

    aput-byte v4, v0, v2

    const/16 v2, 0xe2

    aput-byte v4, v0, v2

    const/16 v2, 0xe3

    aput-byte v4, v0, v2

    const/16 v2, 0xe4

    aput-byte v4, v0, v2

    const/16 v2, 0xe5

    aput-byte v4, v0, v2

    const/16 v2, 0xe6

    aput-byte v4, v0, v2

    const/16 v2, 0xe7

    .line 303
    aput-byte v4, v0, v2

    const/16 v2, 0xe8

    aput-byte v4, v0, v2

    const/16 v2, 0xe9

    aput-byte v4, v0, v2

    const/16 v2, 0xea

    aput-byte v4, v0, v2

    const/16 v2, 0xeb

    aput-byte v4, v0, v2

    const/16 v2, 0xec

    aput-byte v4, v0, v2

    const/16 v2, 0xed

    aput-byte v4, v0, v2

    const/16 v2, 0xee

    aput-byte v4, v0, v2

    const/16 v2, 0xef

    aput-byte v4, v0, v2

    const/16 v2, 0xf0

    aput-byte v4, v0, v2

    const/16 v2, 0xf1

    aput-byte v4, v0, v2

    const/16 v2, 0xf2

    aput-byte v4, v0, v2

    const/16 v2, 0xf3

    aput-byte v4, v0, v2

    const/16 v2, 0xf4

    .line 305
    aput-byte v4, v0, v2

    const/16 v2, 0xf5

    aput-byte v4, v0, v2

    const/16 v2, 0xf6

    aput-byte v4, v0, v2

    const/16 v2, 0xf7

    aput-byte v4, v0, v2

    const/16 v2, 0xf8

    aput-byte v4, v0, v2

    const/16 v2, 0xf9

    aput-byte v4, v0, v2

    const/16 v2, 0xfa

    aput-byte v4, v0, v2

    const/16 v2, 0xfb

    aput-byte v4, v0, v2

    const/16 v2, 0xfc

    aput-byte v4, v0, v2

    const/16 v2, 0xfd

    aput-byte v4, v0, v2

    const/16 v2, 0xfe

    aput-byte v4, v0, v2

    const/16 v2, 0xff

    aput-byte v4, v0, v2

    .line 260
    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_STANDARD_DECODABET:[B

    .line 317
    const/16 v0, 0x40

    new-array v0, v0, [B

    fill-array-data v0, :array_1

    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_URL_SAFE_ALPHABET:[B

    .line 335
    const/16 v0, 0x100

    new-array v0, v0, [B

    const/4 v2, 0x0

    aput-byte v4, v0, v2

    aput-byte v4, v0, v1

    aput-byte v4, v0, v6

    aput-byte v4, v0, v7

    const/4 v2, 0x4

    aput-byte v4, v0, v2

    const/4 v2, 0x5

    aput-byte v4, v0, v2

    const/4 v2, 0x6

    .line 336
    aput-byte v4, v0, v2

    const/4 v2, 0x7

    aput-byte v4, v0, v2

    const/16 v2, 0x8

    aput-byte v4, v0, v2

    const/16 v2, 0x9

    .line 337
    aput-byte v5, v0, v2

    const/16 v2, 0xa

    aput-byte v5, v0, v2

    const/16 v2, 0xb

    .line 338
    aput-byte v4, v0, v2

    const/16 v2, 0xc

    aput-byte v4, v0, v2

    const/16 v2, 0xd

    .line 339
    aput-byte v5, v0, v2

    const/16 v2, 0xe

    .line 340
    aput-byte v4, v0, v2

    const/16 v2, 0xf

    aput-byte v4, v0, v2

    const/16 v2, 0x10

    aput-byte v4, v0, v2

    const/16 v2, 0x11

    aput-byte v4, v0, v2

    const/16 v2, 0x12

    aput-byte v4, v0, v2

    const/16 v2, 0x13

    aput-byte v4, v0, v2

    const/16 v2, 0x14

    aput-byte v4, v0, v2

    const/16 v2, 0x15

    aput-byte v4, v0, v2

    const/16 v2, 0x16

    aput-byte v4, v0, v2

    const/16 v2, 0x17

    aput-byte v4, v0, v2

    const/16 v2, 0x18

    aput-byte v4, v0, v2

    const/16 v2, 0x19

    aput-byte v4, v0, v2

    const/16 v2, 0x1a

    aput-byte v4, v0, v2

    const/16 v2, 0x1b

    .line 342
    aput-byte v4, v0, v2

    const/16 v2, 0x1c

    aput-byte v4, v0, v2

    const/16 v2, 0x1d

    aput-byte v4, v0, v2

    const/16 v2, 0x1e

    aput-byte v4, v0, v2

    const/16 v2, 0x1f

    aput-byte v4, v0, v2

    const/16 v2, 0x20

    .line 343
    aput-byte v5, v0, v2

    const/16 v2, 0x21

    .line 344
    aput-byte v4, v0, v2

    const/16 v2, 0x22

    aput-byte v4, v0, v2

    const/16 v2, 0x23

    aput-byte v4, v0, v2

    const/16 v2, 0x24

    aput-byte v4, v0, v2

    const/16 v2, 0x25

    aput-byte v4, v0, v2

    const/16 v2, 0x26

    aput-byte v4, v0, v2

    const/16 v2, 0x27

    aput-byte v4, v0, v2

    const/16 v2, 0x28

    aput-byte v4, v0, v2

    const/16 v2, 0x29

    aput-byte v4, v0, v2

    const/16 v2, 0x2a

    aput-byte v4, v0, v2

    const/16 v2, 0x2b

    .line 345
    aput-byte v4, v0, v2

    const/16 v2, 0x2c

    .line 346
    aput-byte v4, v0, v2

    const/16 v2, 0x2d

    .line 347
    const/16 v3, 0x3e

    aput-byte v3, v0, v2

    const/16 v2, 0x2e

    .line 348
    aput-byte v4, v0, v2

    const/16 v2, 0x2f

    .line 349
    aput-byte v4, v0, v2

    const/16 v2, 0x30

    .line 350
    const/16 v3, 0x34

    aput-byte v3, v0, v2

    const/16 v2, 0x31

    const/16 v3, 0x35

    aput-byte v3, v0, v2

    const/16 v2, 0x32

    const/16 v3, 0x36

    aput-byte v3, v0, v2

    const/16 v2, 0x33

    const/16 v3, 0x37

    aput-byte v3, v0, v2

    const/16 v2, 0x34

    const/16 v3, 0x38

    aput-byte v3, v0, v2

    const/16 v2, 0x35

    const/16 v3, 0x39

    aput-byte v3, v0, v2

    const/16 v2, 0x36

    const/16 v3, 0x3a

    aput-byte v3, v0, v2

    const/16 v2, 0x37

    const/16 v3, 0x3b

    aput-byte v3, v0, v2

    const/16 v2, 0x38

    const/16 v3, 0x3c

    aput-byte v3, v0, v2

    const/16 v2, 0x39

    const/16 v3, 0x3d

    aput-byte v3, v0, v2

    const/16 v2, 0x3a

    .line 351
    aput-byte v4, v0, v2

    const/16 v2, 0x3b

    aput-byte v4, v0, v2

    const/16 v2, 0x3c

    aput-byte v4, v0, v2

    const/16 v2, 0x3d

    .line 352
    const/4 v3, -0x1

    aput-byte v3, v0, v2

    const/16 v2, 0x3e

    .line 353
    aput-byte v4, v0, v2

    const/16 v2, 0x3f

    aput-byte v4, v0, v2

    const/16 v2, 0x40

    aput-byte v4, v0, v2

    const/16 v2, 0x42

    .line 354
    aput-byte v1, v0, v2

    const/16 v2, 0x43

    aput-byte v6, v0, v2

    const/16 v2, 0x44

    aput-byte v7, v0, v2

    const/16 v2, 0x45

    const/4 v3, 0x4

    aput-byte v3, v0, v2

    const/16 v2, 0x46

    const/4 v3, 0x5

    aput-byte v3, v0, v2

    const/16 v2, 0x47

    const/4 v3, 0x6

    aput-byte v3, v0, v2

    const/16 v2, 0x48

    const/4 v3, 0x7

    aput-byte v3, v0, v2

    const/16 v2, 0x49

    const/16 v3, 0x8

    aput-byte v3, v0, v2

    const/16 v2, 0x4a

    const/16 v3, 0x9

    aput-byte v3, v0, v2

    const/16 v2, 0x4b

    const/16 v3, 0xa

    aput-byte v3, v0, v2

    const/16 v2, 0x4c

    const/16 v3, 0xb

    aput-byte v3, v0, v2

    const/16 v2, 0x4d

    const/16 v3, 0xc

    aput-byte v3, v0, v2

    const/16 v2, 0x4e

    const/16 v3, 0xd

    aput-byte v3, v0, v2

    const/16 v2, 0x4f

    .line 356
    const/16 v3, 0xe

    aput-byte v3, v0, v2

    const/16 v2, 0x50

    const/16 v3, 0xf

    aput-byte v3, v0, v2

    const/16 v2, 0x51

    const/16 v3, 0x10

    aput-byte v3, v0, v2

    const/16 v2, 0x52

    const/16 v3, 0x11

    aput-byte v3, v0, v2

    const/16 v2, 0x53

    const/16 v3, 0x12

    aput-byte v3, v0, v2

    const/16 v2, 0x54

    const/16 v3, 0x13

    aput-byte v3, v0, v2

    const/16 v2, 0x55

    const/16 v3, 0x14

    aput-byte v3, v0, v2

    const/16 v2, 0x56

    const/16 v3, 0x15

    aput-byte v3, v0, v2

    const/16 v2, 0x57

    const/16 v3, 0x16

    aput-byte v3, v0, v2

    const/16 v2, 0x58

    const/16 v3, 0x17

    aput-byte v3, v0, v2

    const/16 v2, 0x59

    const/16 v3, 0x18

    aput-byte v3, v0, v2

    const/16 v2, 0x5a

    const/16 v3, 0x19

    aput-byte v3, v0, v2

    const/16 v2, 0x5b

    .line 358
    aput-byte v4, v0, v2

    const/16 v2, 0x5c

    aput-byte v4, v0, v2

    const/16 v2, 0x5d

    aput-byte v4, v0, v2

    const/16 v2, 0x5e

    aput-byte v4, v0, v2

    const/16 v2, 0x5f

    .line 359
    const/16 v3, 0x3f

    aput-byte v3, v0, v2

    const/16 v2, 0x60

    .line 360
    aput-byte v4, v0, v2

    const/16 v2, 0x61

    .line 361
    const/16 v3, 0x1a

    aput-byte v3, v0, v2

    const/16 v2, 0x62

    const/16 v3, 0x1b

    aput-byte v3, v0, v2

    const/16 v2, 0x63

    const/16 v3, 0x1c

    aput-byte v3, v0, v2

    const/16 v2, 0x64

    const/16 v3, 0x1d

    aput-byte v3, v0, v2

    const/16 v2, 0x65

    const/16 v3, 0x1e

    aput-byte v3, v0, v2

    const/16 v2, 0x66

    const/16 v3, 0x1f

    aput-byte v3, v0, v2

    const/16 v2, 0x67

    const/16 v3, 0x20

    aput-byte v3, v0, v2

    const/16 v2, 0x68

    const/16 v3, 0x21

    aput-byte v3, v0, v2

    const/16 v2, 0x69

    const/16 v3, 0x22

    aput-byte v3, v0, v2

    const/16 v2, 0x6a

    const/16 v3, 0x23

    aput-byte v3, v0, v2

    const/16 v2, 0x6b

    const/16 v3, 0x24

    aput-byte v3, v0, v2

    const/16 v2, 0x6c

    const/16 v3, 0x25

    aput-byte v3, v0, v2

    const/16 v2, 0x6d

    const/16 v3, 0x26

    aput-byte v3, v0, v2

    const/16 v2, 0x6e

    .line 363
    const/16 v3, 0x27

    aput-byte v3, v0, v2

    const/16 v2, 0x6f

    const/16 v3, 0x28

    aput-byte v3, v0, v2

    const/16 v2, 0x70

    const/16 v3, 0x29

    aput-byte v3, v0, v2

    const/16 v2, 0x71

    const/16 v3, 0x2a

    aput-byte v3, v0, v2

    const/16 v2, 0x72

    const/16 v3, 0x2b

    aput-byte v3, v0, v2

    const/16 v2, 0x73

    const/16 v3, 0x2c

    aput-byte v3, v0, v2

    const/16 v2, 0x74

    const/16 v3, 0x2d

    aput-byte v3, v0, v2

    const/16 v2, 0x75

    const/16 v3, 0x2e

    aput-byte v3, v0, v2

    const/16 v2, 0x76

    const/16 v3, 0x2f

    aput-byte v3, v0, v2

    const/16 v2, 0x77

    const/16 v3, 0x30

    aput-byte v3, v0, v2

    const/16 v2, 0x78

    const/16 v3, 0x31

    aput-byte v3, v0, v2

    const/16 v2, 0x79

    const/16 v3, 0x32

    aput-byte v3, v0, v2

    const/16 v2, 0x7a

    const/16 v3, 0x33

    aput-byte v3, v0, v2

    const/16 v2, 0x7b

    .line 365
    aput-byte v4, v0, v2

    const/16 v2, 0x7c

    aput-byte v4, v0, v2

    const/16 v2, 0x7d

    aput-byte v4, v0, v2

    const/16 v2, 0x7e

    aput-byte v4, v0, v2

    const/16 v2, 0x7f

    aput-byte v4, v0, v2

    const/16 v2, 0x80

    .line 366
    aput-byte v4, v0, v2

    const/16 v2, 0x81

    aput-byte v4, v0, v2

    const/16 v2, 0x82

    aput-byte v4, v0, v2

    const/16 v2, 0x83

    aput-byte v4, v0, v2

    const/16 v2, 0x84

    aput-byte v4, v0, v2

    const/16 v2, 0x85

    aput-byte v4, v0, v2

    const/16 v2, 0x86

    aput-byte v4, v0, v2

    const/16 v2, 0x87

    aput-byte v4, v0, v2

    const/16 v2, 0x88

    aput-byte v4, v0, v2

    const/16 v2, 0x89

    aput-byte v4, v0, v2

    const/16 v2, 0x8a

    aput-byte v4, v0, v2

    const/16 v2, 0x8b

    aput-byte v4, v0, v2

    const/16 v2, 0x8c

    .line 368
    aput-byte v4, v0, v2

    const/16 v2, 0x8d

    aput-byte v4, v0, v2

    const/16 v2, 0x8e

    aput-byte v4, v0, v2

    const/16 v2, 0x8f

    aput-byte v4, v0, v2

    const/16 v2, 0x90

    aput-byte v4, v0, v2

    const/16 v2, 0x91

    aput-byte v4, v0, v2

    const/16 v2, 0x92

    aput-byte v4, v0, v2

    const/16 v2, 0x93

    aput-byte v4, v0, v2

    const/16 v2, 0x94

    aput-byte v4, v0, v2

    const/16 v2, 0x95

    aput-byte v4, v0, v2

    const/16 v2, 0x96

    aput-byte v4, v0, v2

    const/16 v2, 0x97

    aput-byte v4, v0, v2

    const/16 v2, 0x98

    aput-byte v4, v0, v2

    const/16 v2, 0x99

    .line 370
    aput-byte v4, v0, v2

    const/16 v2, 0x9a

    aput-byte v4, v0, v2

    const/16 v2, 0x9b

    aput-byte v4, v0, v2

    const/16 v2, 0x9c

    aput-byte v4, v0, v2

    const/16 v2, 0x9d

    aput-byte v4, v0, v2

    const/16 v2, 0x9e

    aput-byte v4, v0, v2

    const/16 v2, 0x9f

    aput-byte v4, v0, v2

    const/16 v2, 0xa0

    aput-byte v4, v0, v2

    const/16 v2, 0xa1

    aput-byte v4, v0, v2

    const/16 v2, 0xa2

    aput-byte v4, v0, v2

    const/16 v2, 0xa3

    aput-byte v4, v0, v2

    const/16 v2, 0xa4

    aput-byte v4, v0, v2

    const/16 v2, 0xa5

    aput-byte v4, v0, v2

    const/16 v2, 0xa6

    .line 372
    aput-byte v4, v0, v2

    const/16 v2, 0xa7

    aput-byte v4, v0, v2

    const/16 v2, 0xa8

    aput-byte v4, v0, v2

    const/16 v2, 0xa9

    aput-byte v4, v0, v2

    const/16 v2, 0xaa

    aput-byte v4, v0, v2

    const/16 v2, 0xab

    aput-byte v4, v0, v2

    const/16 v2, 0xac

    aput-byte v4, v0, v2

    const/16 v2, 0xad

    aput-byte v4, v0, v2

    const/16 v2, 0xae

    aput-byte v4, v0, v2

    const/16 v2, 0xaf

    aput-byte v4, v0, v2

    const/16 v2, 0xb0

    aput-byte v4, v0, v2

    const/16 v2, 0xb1

    aput-byte v4, v0, v2

    const/16 v2, 0xb2

    aput-byte v4, v0, v2

    const/16 v2, 0xb3

    .line 374
    aput-byte v4, v0, v2

    const/16 v2, 0xb4

    aput-byte v4, v0, v2

    const/16 v2, 0xb5

    aput-byte v4, v0, v2

    const/16 v2, 0xb6

    aput-byte v4, v0, v2

    const/16 v2, 0xb7

    aput-byte v4, v0, v2

    const/16 v2, 0xb8

    aput-byte v4, v0, v2

    const/16 v2, 0xb9

    aput-byte v4, v0, v2

    const/16 v2, 0xba

    aput-byte v4, v0, v2

    const/16 v2, 0xbb

    aput-byte v4, v0, v2

    const/16 v2, 0xbc

    aput-byte v4, v0, v2

    const/16 v2, 0xbd

    aput-byte v4, v0, v2

    const/16 v2, 0xbe

    aput-byte v4, v0, v2

    const/16 v2, 0xbf

    aput-byte v4, v0, v2

    const/16 v2, 0xc0

    .line 376
    aput-byte v4, v0, v2

    const/16 v2, 0xc1

    aput-byte v4, v0, v2

    const/16 v2, 0xc2

    aput-byte v4, v0, v2

    const/16 v2, 0xc3

    aput-byte v4, v0, v2

    const/16 v2, 0xc4

    aput-byte v4, v0, v2

    const/16 v2, 0xc5

    aput-byte v4, v0, v2

    const/16 v2, 0xc6

    aput-byte v4, v0, v2

    const/16 v2, 0xc7

    aput-byte v4, v0, v2

    const/16 v2, 0xc8

    aput-byte v4, v0, v2

    const/16 v2, 0xc9

    aput-byte v4, v0, v2

    const/16 v2, 0xca

    aput-byte v4, v0, v2

    const/16 v2, 0xcb

    aput-byte v4, v0, v2

    const/16 v2, 0xcc

    aput-byte v4, v0, v2

    const/16 v2, 0xcd

    .line 378
    aput-byte v4, v0, v2

    const/16 v2, 0xce

    aput-byte v4, v0, v2

    const/16 v2, 0xcf

    aput-byte v4, v0, v2

    const/16 v2, 0xd0

    aput-byte v4, v0, v2

    const/16 v2, 0xd1

    aput-byte v4, v0, v2

    const/16 v2, 0xd2

    aput-byte v4, v0, v2

    const/16 v2, 0xd3

    aput-byte v4, v0, v2

    const/16 v2, 0xd4

    aput-byte v4, v0, v2

    const/16 v2, 0xd5

    aput-byte v4, v0, v2

    const/16 v2, 0xd6

    aput-byte v4, v0, v2

    const/16 v2, 0xd7

    aput-byte v4, v0, v2

    const/16 v2, 0xd8

    aput-byte v4, v0, v2

    const/16 v2, 0xd9

    aput-byte v4, v0, v2

    const/16 v2, 0xda

    .line 380
    aput-byte v4, v0, v2

    const/16 v2, 0xdb

    aput-byte v4, v0, v2

    const/16 v2, 0xdc

    aput-byte v4, v0, v2

    const/16 v2, 0xdd

    aput-byte v4, v0, v2

    const/16 v2, 0xde

    aput-byte v4, v0, v2

    const/16 v2, 0xdf

    aput-byte v4, v0, v2

    const/16 v2, 0xe0

    aput-byte v4, v0, v2

    const/16 v2, 0xe1

    aput-byte v4, v0, v2

    const/16 v2, 0xe2

    aput-byte v4, v0, v2

    const/16 v2, 0xe3

    aput-byte v4, v0, v2

    const/16 v2, 0xe4

    aput-byte v4, v0, v2

    const/16 v2, 0xe5

    aput-byte v4, v0, v2

    const/16 v2, 0xe6

    aput-byte v4, v0, v2

    const/16 v2, 0xe7

    .line 382
    aput-byte v4, v0, v2

    const/16 v2, 0xe8

    aput-byte v4, v0, v2

    const/16 v2, 0xe9

    aput-byte v4, v0, v2

    const/16 v2, 0xea

    aput-byte v4, v0, v2

    const/16 v2, 0xeb

    aput-byte v4, v0, v2

    const/16 v2, 0xec

    aput-byte v4, v0, v2

    const/16 v2, 0xed

    aput-byte v4, v0, v2

    const/16 v2, 0xee

    aput-byte v4, v0, v2

    const/16 v2, 0xef

    aput-byte v4, v0, v2

    const/16 v2, 0xf0

    aput-byte v4, v0, v2

    const/16 v2, 0xf1

    aput-byte v4, v0, v2

    const/16 v2, 0xf2

    aput-byte v4, v0, v2

    const/16 v2, 0xf3

    aput-byte v4, v0, v2

    const/16 v2, 0xf4

    .line 384
    aput-byte v4, v0, v2

    const/16 v2, 0xf5

    aput-byte v4, v0, v2

    const/16 v2, 0xf6

    aput-byte v4, v0, v2

    const/16 v2, 0xf7

    aput-byte v4, v0, v2

    const/16 v2, 0xf8

    aput-byte v4, v0, v2

    const/16 v2, 0xf9

    aput-byte v4, v0, v2

    const/16 v2, 0xfa

    aput-byte v4, v0, v2

    const/16 v2, 0xfb

    aput-byte v4, v0, v2

    const/16 v2, 0xfc

    aput-byte v4, v0, v2

    const/16 v2, 0xfd

    aput-byte v4, v0, v2

    const/16 v2, 0xfe

    aput-byte v4, v0, v2

    const/16 v2, 0xff

    aput-byte v4, v0, v2

    .line 335
    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_URL_SAFE_DECODABET:[B

    .line 395
    const/16 v0, 0x40

    new-array v0, v0, [B

    fill-array-data v0, :array_2

    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_ORDERED_ALPHABET:[B

    .line 413
    const/16 v0, 0x101

    new-array v0, v0, [B

    const/4 v2, 0x0

    aput-byte v4, v0, v2

    aput-byte v4, v0, v1

    aput-byte v4, v0, v6

    aput-byte v4, v0, v7

    const/4 v2, 0x4

    aput-byte v4, v0, v2

    const/4 v2, 0x5

    aput-byte v4, v0, v2

    const/4 v2, 0x6

    .line 414
    aput-byte v4, v0, v2

    const/4 v2, 0x7

    aput-byte v4, v0, v2

    const/16 v2, 0x8

    aput-byte v4, v0, v2

    const/16 v2, 0x9

    .line 415
    aput-byte v5, v0, v2

    const/16 v2, 0xa

    aput-byte v5, v0, v2

    const/16 v2, 0xb

    .line 416
    aput-byte v4, v0, v2

    const/16 v2, 0xc

    aput-byte v4, v0, v2

    const/16 v2, 0xd

    .line 417
    aput-byte v5, v0, v2

    const/16 v2, 0xe

    .line 418
    aput-byte v4, v0, v2

    const/16 v2, 0xf

    aput-byte v4, v0, v2

    const/16 v2, 0x10

    aput-byte v4, v0, v2

    const/16 v2, 0x11

    aput-byte v4, v0, v2

    const/16 v2, 0x12

    aput-byte v4, v0, v2

    const/16 v2, 0x13

    aput-byte v4, v0, v2

    const/16 v2, 0x14

    aput-byte v4, v0, v2

    const/16 v2, 0x15

    aput-byte v4, v0, v2

    const/16 v2, 0x16

    aput-byte v4, v0, v2

    const/16 v2, 0x17

    aput-byte v4, v0, v2

    const/16 v2, 0x18

    aput-byte v4, v0, v2

    const/16 v2, 0x19

    aput-byte v4, v0, v2

    const/16 v2, 0x1a

    aput-byte v4, v0, v2

    const/16 v2, 0x1b

    .line 420
    aput-byte v4, v0, v2

    const/16 v2, 0x1c

    aput-byte v4, v0, v2

    const/16 v2, 0x1d

    aput-byte v4, v0, v2

    const/16 v2, 0x1e

    aput-byte v4, v0, v2

    const/16 v2, 0x1f

    aput-byte v4, v0, v2

    const/16 v2, 0x20

    .line 421
    aput-byte v5, v0, v2

    const/16 v2, 0x21

    .line 422
    aput-byte v4, v0, v2

    const/16 v2, 0x22

    aput-byte v4, v0, v2

    const/16 v2, 0x23

    aput-byte v4, v0, v2

    const/16 v2, 0x24

    aput-byte v4, v0, v2

    const/16 v2, 0x25

    aput-byte v4, v0, v2

    const/16 v2, 0x26

    aput-byte v4, v0, v2

    const/16 v2, 0x27

    aput-byte v4, v0, v2

    const/16 v2, 0x28

    aput-byte v4, v0, v2

    const/16 v2, 0x29

    aput-byte v4, v0, v2

    const/16 v2, 0x2a

    aput-byte v4, v0, v2

    const/16 v2, 0x2b

    .line 423
    aput-byte v4, v0, v2

    const/16 v2, 0x2c

    .line 424
    aput-byte v4, v0, v2

    const/16 v2, 0x2e

    .line 426
    aput-byte v4, v0, v2

    const/16 v2, 0x2f

    .line 427
    aput-byte v4, v0, v2

    const/16 v2, 0x30

    .line 428
    aput-byte v1, v0, v2

    const/16 v1, 0x31

    aput-byte v6, v0, v1

    const/16 v1, 0x32

    aput-byte v7, v0, v1

    const/16 v1, 0x33

    const/4 v2, 0x4

    aput-byte v2, v0, v1

    const/16 v1, 0x34

    const/4 v2, 0x5

    aput-byte v2, v0, v1

    const/16 v1, 0x35

    const/4 v2, 0x6

    aput-byte v2, v0, v1

    const/16 v1, 0x36

    const/4 v2, 0x7

    aput-byte v2, v0, v1

    const/16 v1, 0x37

    const/16 v2, 0x8

    aput-byte v2, v0, v1

    const/16 v1, 0x38

    const/16 v2, 0x9

    aput-byte v2, v0, v1

    const/16 v1, 0x39

    const/16 v2, 0xa

    aput-byte v2, v0, v1

    const/16 v1, 0x3a

    .line 429
    aput-byte v4, v0, v1

    const/16 v1, 0x3b

    aput-byte v4, v0, v1

    const/16 v1, 0x3c

    aput-byte v4, v0, v1

    const/16 v1, 0x3d

    .line 430
    const/4 v2, -0x1

    aput-byte v2, v0, v1

    const/16 v1, 0x3e

    .line 431
    aput-byte v4, v0, v1

    const/16 v1, 0x3f

    aput-byte v4, v0, v1

    const/16 v1, 0x40

    aput-byte v4, v0, v1

    const/16 v1, 0x41

    .line 432
    const/16 v2, 0xb

    aput-byte v2, v0, v1

    const/16 v1, 0x42

    const/16 v2, 0xc

    aput-byte v2, v0, v1

    const/16 v1, 0x43

    const/16 v2, 0xd

    aput-byte v2, v0, v1

    const/16 v1, 0x44

    const/16 v2, 0xe

    aput-byte v2, v0, v1

    const/16 v1, 0x45

    const/16 v2, 0xf

    aput-byte v2, v0, v1

    const/16 v1, 0x46

    const/16 v2, 0x10

    aput-byte v2, v0, v1

    const/16 v1, 0x47

    const/16 v2, 0x11

    aput-byte v2, v0, v1

    const/16 v1, 0x48

    const/16 v2, 0x12

    aput-byte v2, v0, v1

    const/16 v1, 0x49

    const/16 v2, 0x13

    aput-byte v2, v0, v1

    const/16 v1, 0x4a

    const/16 v2, 0x14

    aput-byte v2, v0, v1

    const/16 v1, 0x4b

    const/16 v2, 0x15

    aput-byte v2, v0, v1

    const/16 v1, 0x4c

    const/16 v2, 0x16

    aput-byte v2, v0, v1

    const/16 v1, 0x4d

    const/16 v2, 0x17

    aput-byte v2, v0, v1

    const/16 v1, 0x4e

    .line 434
    const/16 v2, 0x18

    aput-byte v2, v0, v1

    const/16 v1, 0x4f

    const/16 v2, 0x19

    aput-byte v2, v0, v1

    const/16 v1, 0x50

    const/16 v2, 0x1a

    aput-byte v2, v0, v1

    const/16 v1, 0x51

    const/16 v2, 0x1b

    aput-byte v2, v0, v1

    const/16 v1, 0x52

    const/16 v2, 0x1c

    aput-byte v2, v0, v1

    const/16 v1, 0x53

    const/16 v2, 0x1d

    aput-byte v2, v0, v1

    const/16 v1, 0x54

    const/16 v2, 0x1e

    aput-byte v2, v0, v1

    const/16 v1, 0x55

    const/16 v2, 0x1f

    aput-byte v2, v0, v1

    const/16 v1, 0x56

    const/16 v2, 0x20

    aput-byte v2, v0, v1

    const/16 v1, 0x57

    const/16 v2, 0x21

    aput-byte v2, v0, v1

    const/16 v1, 0x58

    const/16 v2, 0x22

    aput-byte v2, v0, v1

    const/16 v1, 0x59

    const/16 v2, 0x23

    aput-byte v2, v0, v1

    const/16 v1, 0x5a

    const/16 v2, 0x24

    aput-byte v2, v0, v1

    const/16 v1, 0x5b

    .line 436
    aput-byte v4, v0, v1

    const/16 v1, 0x5c

    aput-byte v4, v0, v1

    const/16 v1, 0x5d

    aput-byte v4, v0, v1

    const/16 v1, 0x5e

    aput-byte v4, v0, v1

    const/16 v1, 0x5f

    .line 437
    const/16 v2, 0x25

    aput-byte v2, v0, v1

    const/16 v1, 0x60

    .line 438
    aput-byte v4, v0, v1

    const/16 v1, 0x61

    .line 439
    const/16 v2, 0x26

    aput-byte v2, v0, v1

    const/16 v1, 0x62

    const/16 v2, 0x27

    aput-byte v2, v0, v1

    const/16 v1, 0x63

    const/16 v2, 0x28

    aput-byte v2, v0, v1

    const/16 v1, 0x64

    const/16 v2, 0x29

    aput-byte v2, v0, v1

    const/16 v1, 0x65

    const/16 v2, 0x2a

    aput-byte v2, v0, v1

    const/16 v1, 0x66

    const/16 v2, 0x2b

    aput-byte v2, v0, v1

    const/16 v1, 0x67

    const/16 v2, 0x2c

    aput-byte v2, v0, v1

    const/16 v1, 0x68

    const/16 v2, 0x2d

    aput-byte v2, v0, v1

    const/16 v1, 0x69

    const/16 v2, 0x2e

    aput-byte v2, v0, v1

    const/16 v1, 0x6a

    const/16 v2, 0x2f

    aput-byte v2, v0, v1

    const/16 v1, 0x6b

    const/16 v2, 0x30

    aput-byte v2, v0, v1

    const/16 v1, 0x6c

    const/16 v2, 0x31

    aput-byte v2, v0, v1

    const/16 v1, 0x6d

    const/16 v2, 0x32

    aput-byte v2, v0, v1

    const/16 v1, 0x6e

    .line 441
    const/16 v2, 0x33

    aput-byte v2, v0, v1

    const/16 v1, 0x6f

    const/16 v2, 0x34

    aput-byte v2, v0, v1

    const/16 v1, 0x70

    const/16 v2, 0x35

    aput-byte v2, v0, v1

    const/16 v1, 0x71

    const/16 v2, 0x36

    aput-byte v2, v0, v1

    const/16 v1, 0x72

    const/16 v2, 0x37

    aput-byte v2, v0, v1

    const/16 v1, 0x73

    const/16 v2, 0x38

    aput-byte v2, v0, v1

    const/16 v1, 0x74

    const/16 v2, 0x39

    aput-byte v2, v0, v1

    const/16 v1, 0x75

    const/16 v2, 0x3a

    aput-byte v2, v0, v1

    const/16 v1, 0x76

    const/16 v2, 0x3b

    aput-byte v2, v0, v1

    const/16 v1, 0x77

    const/16 v2, 0x3c

    aput-byte v2, v0, v1

    const/16 v1, 0x78

    const/16 v2, 0x3d

    aput-byte v2, v0, v1

    const/16 v1, 0x79

    const/16 v2, 0x3e

    aput-byte v2, v0, v1

    const/16 v1, 0x7a

    const/16 v2, 0x3f

    aput-byte v2, v0, v1

    const/16 v1, 0x7b

    .line 443
    aput-byte v4, v0, v1

    const/16 v1, 0x7c

    aput-byte v4, v0, v1

    const/16 v1, 0x7d

    aput-byte v4, v0, v1

    const/16 v1, 0x7e

    aput-byte v4, v0, v1

    const/16 v1, 0x7f

    aput-byte v4, v0, v1

    const/16 v1, 0x80

    .line 444
    aput-byte v4, v0, v1

    const/16 v1, 0x81

    aput-byte v4, v0, v1

    const/16 v1, 0x82

    aput-byte v4, v0, v1

    const/16 v1, 0x83

    aput-byte v4, v0, v1

    const/16 v1, 0x84

    aput-byte v4, v0, v1

    const/16 v1, 0x85

    aput-byte v4, v0, v1

    const/16 v1, 0x86

    aput-byte v4, v0, v1

    const/16 v1, 0x87

    aput-byte v4, v0, v1

    const/16 v1, 0x88

    aput-byte v4, v0, v1

    const/16 v1, 0x89

    aput-byte v4, v0, v1

    const/16 v1, 0x8a

    aput-byte v4, v0, v1

    const/16 v1, 0x8b

    aput-byte v4, v0, v1

    const/16 v1, 0x8c

    aput-byte v4, v0, v1

    const/16 v1, 0x8d

    .line 446
    aput-byte v4, v0, v1

    const/16 v1, 0x8e

    aput-byte v4, v0, v1

    const/16 v1, 0x8f

    aput-byte v4, v0, v1

    const/16 v1, 0x90

    aput-byte v4, v0, v1

    const/16 v1, 0x91

    aput-byte v4, v0, v1

    const/16 v1, 0x92

    aput-byte v4, v0, v1

    const/16 v1, 0x93

    aput-byte v4, v0, v1

    const/16 v1, 0x94

    aput-byte v4, v0, v1

    const/16 v1, 0x95

    aput-byte v4, v0, v1

    const/16 v1, 0x96

    aput-byte v4, v0, v1

    const/16 v1, 0x97

    aput-byte v4, v0, v1

    const/16 v1, 0x98

    aput-byte v4, v0, v1

    const/16 v1, 0x99

    aput-byte v4, v0, v1

    const/16 v1, 0x9a

    .line 448
    aput-byte v4, v0, v1

    const/16 v1, 0x9b

    aput-byte v4, v0, v1

    const/16 v1, 0x9c

    aput-byte v4, v0, v1

    const/16 v1, 0x9d

    aput-byte v4, v0, v1

    const/16 v1, 0x9e

    aput-byte v4, v0, v1

    const/16 v1, 0x9f

    aput-byte v4, v0, v1

    const/16 v1, 0xa0

    aput-byte v4, v0, v1

    const/16 v1, 0xa1

    aput-byte v4, v0, v1

    const/16 v1, 0xa2

    aput-byte v4, v0, v1

    const/16 v1, 0xa3

    aput-byte v4, v0, v1

    const/16 v1, 0xa4

    aput-byte v4, v0, v1

    const/16 v1, 0xa5

    aput-byte v4, v0, v1

    const/16 v1, 0xa6

    aput-byte v4, v0, v1

    const/16 v1, 0xa7

    .line 450
    aput-byte v4, v0, v1

    const/16 v1, 0xa8

    aput-byte v4, v0, v1

    const/16 v1, 0xa9

    aput-byte v4, v0, v1

    const/16 v1, 0xaa

    aput-byte v4, v0, v1

    const/16 v1, 0xab

    aput-byte v4, v0, v1

    const/16 v1, 0xac

    aput-byte v4, v0, v1

    const/16 v1, 0xad

    aput-byte v4, v0, v1

    const/16 v1, 0xae

    aput-byte v4, v0, v1

    const/16 v1, 0xaf

    aput-byte v4, v0, v1

    const/16 v1, 0xb0

    aput-byte v4, v0, v1

    const/16 v1, 0xb1

    aput-byte v4, v0, v1

    const/16 v1, 0xb2

    aput-byte v4, v0, v1

    const/16 v1, 0xb3

    aput-byte v4, v0, v1

    const/16 v1, 0xb4

    .line 452
    aput-byte v4, v0, v1

    const/16 v1, 0xb5

    aput-byte v4, v0, v1

    const/16 v1, 0xb6

    aput-byte v4, v0, v1

    const/16 v1, 0xb7

    aput-byte v4, v0, v1

    const/16 v1, 0xb8

    aput-byte v4, v0, v1

    const/16 v1, 0xb9

    aput-byte v4, v0, v1

    const/16 v1, 0xba

    aput-byte v4, v0, v1

    const/16 v1, 0xbb

    aput-byte v4, v0, v1

    const/16 v1, 0xbc

    aput-byte v4, v0, v1

    const/16 v1, 0xbd

    aput-byte v4, v0, v1

    const/16 v1, 0xbe

    aput-byte v4, v0, v1

    const/16 v1, 0xbf

    aput-byte v4, v0, v1

    const/16 v1, 0xc0

    aput-byte v4, v0, v1

    const/16 v1, 0xc1

    .line 454
    aput-byte v4, v0, v1

    const/16 v1, 0xc2

    aput-byte v4, v0, v1

    const/16 v1, 0xc3

    aput-byte v4, v0, v1

    const/16 v1, 0xc4

    aput-byte v4, v0, v1

    const/16 v1, 0xc5

    aput-byte v4, v0, v1

    const/16 v1, 0xc6

    aput-byte v4, v0, v1

    const/16 v1, 0xc7

    aput-byte v4, v0, v1

    const/16 v1, 0xc8

    aput-byte v4, v0, v1

    const/16 v1, 0xc9

    aput-byte v4, v0, v1

    const/16 v1, 0xca

    aput-byte v4, v0, v1

    const/16 v1, 0xcb

    aput-byte v4, v0, v1

    const/16 v1, 0xcc

    aput-byte v4, v0, v1

    const/16 v1, 0xcd

    aput-byte v4, v0, v1

    const/16 v1, 0xce

    .line 456
    aput-byte v4, v0, v1

    const/16 v1, 0xcf

    aput-byte v4, v0, v1

    const/16 v1, 0xd0

    aput-byte v4, v0, v1

    const/16 v1, 0xd1

    aput-byte v4, v0, v1

    const/16 v1, 0xd2

    aput-byte v4, v0, v1

    const/16 v1, 0xd3

    aput-byte v4, v0, v1

    const/16 v1, 0xd4

    aput-byte v4, v0, v1

    const/16 v1, 0xd5

    aput-byte v4, v0, v1

    const/16 v1, 0xd6

    aput-byte v4, v0, v1

    const/16 v1, 0xd7

    aput-byte v4, v0, v1

    const/16 v1, 0xd8

    aput-byte v4, v0, v1

    const/16 v1, 0xd9

    aput-byte v4, v0, v1

    const/16 v1, 0xda

    aput-byte v4, v0, v1

    const/16 v1, 0xdb

    .line 458
    aput-byte v4, v0, v1

    const/16 v1, 0xdc

    aput-byte v4, v0, v1

    const/16 v1, 0xdd

    aput-byte v4, v0, v1

    const/16 v1, 0xde

    aput-byte v4, v0, v1

    const/16 v1, 0xdf

    aput-byte v4, v0, v1

    const/16 v1, 0xe0

    aput-byte v4, v0, v1

    const/16 v1, 0xe1

    aput-byte v4, v0, v1

    const/16 v1, 0xe2

    aput-byte v4, v0, v1

    const/16 v1, 0xe3

    aput-byte v4, v0, v1

    const/16 v1, 0xe4

    aput-byte v4, v0, v1

    const/16 v1, 0xe5

    aput-byte v4, v0, v1

    const/16 v1, 0xe6

    aput-byte v4, v0, v1

    const/16 v1, 0xe7

    aput-byte v4, v0, v1

    const/16 v1, 0xe8

    .line 460
    aput-byte v4, v0, v1

    const/16 v1, 0xe9

    aput-byte v4, v0, v1

    const/16 v1, 0xea

    aput-byte v4, v0, v1

    const/16 v1, 0xeb

    aput-byte v4, v0, v1

    const/16 v1, 0xec

    aput-byte v4, v0, v1

    const/16 v1, 0xed

    aput-byte v4, v0, v1

    const/16 v1, 0xee

    aput-byte v4, v0, v1

    const/16 v1, 0xef

    aput-byte v4, v0, v1

    const/16 v1, 0xf0

    aput-byte v4, v0, v1

    const/16 v1, 0xf1

    aput-byte v4, v0, v1

    const/16 v1, 0xf2

    aput-byte v4, v0, v1

    const/16 v1, 0xf3

    aput-byte v4, v0, v1

    const/16 v1, 0xf4

    aput-byte v4, v0, v1

    const/16 v1, 0xf5

    .line 462
    aput-byte v4, v0, v1

    const/16 v1, 0xf6

    aput-byte v4, v0, v1

    const/16 v1, 0xf7

    aput-byte v4, v0, v1

    const/16 v1, 0xf8

    aput-byte v4, v0, v1

    const/16 v1, 0xf9

    aput-byte v4, v0, v1

    const/16 v1, 0xfa

    aput-byte v4, v0, v1

    const/16 v1, 0xfb

    aput-byte v4, v0, v1

    const/16 v1, 0xfc

    aput-byte v4, v0, v1

    const/16 v1, 0xfd

    aput-byte v4, v0, v1

    const/16 v1, 0xfe

    aput-byte v4, v0, v1

    const/16 v1, 0xff

    aput-byte v4, v0, v1

    const/16 v1, 0x100

    aput-byte v4, v0, v1

    .line 413
    sput-object v0, Lcom/aio/downloader/utils/MyBase64;->_ORDERED_DECODABET:[B

    .line 463
    return-void

    .line 173
    :cond_0
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 241
    :array_0
    .array-data 1
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2bt
        0x2ft
    .end array-data

    .line 317
    :array_1
    .array-data 1
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2dt
        0x5ft
    .end array-data

    .line 395
    :array_2
    .array-data 1
        0x2dt
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x5ft
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 500
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 501
    return-void
.end method

.method static synthetic access$0(I)[B
    .locals 1

    .prologue
    .line 489
    invoke-static {p0}, Lcom/aio/downloader/utils/MyBase64;->getDecodabet(I)[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1([BII[BII)[B
    .locals 1

    .prologue
    .line 558
    invoke-static/range {p0 .. p5}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([BII[BII)[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2([BI[BII)I
    .locals 1

    .prologue
    .line 1155
    invoke-static {p0, p1, p2, p3, p4}, Lcom/aio/downloader/utils/MyBase64;->decode4to3([BI[BII)I

    move-result v0

    return v0
.end method

.method static synthetic access$3([B[BII)[B
    .locals 1

    .prologue
    .line 522
    invoke-static {p0, p1, p2, p3}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([B[BII)[B

    move-result-object v0

    return-object v0
.end method

.method public static decode(Ljava/lang/String;)[B
    .locals 1
    .param p0, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1358
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/aio/downloader/utils/MyBase64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    return-object v0
.end method

.method public static decode(Ljava/lang/String;I)[B
    .locals 17
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1379
    if-nez p0, :cond_0

    .line 1380
    new-instance v14, Ljava/lang/NullPointerException;

    const-string v15, "Input string was null."

    invoke-direct {v14, v15}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 1385
    :cond_0
    :try_start_0
    const-string v14, "US-ASCII"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 1393
    .local v6, "bytes":[B
    :goto_0
    const/4 v14, 0x0

    array-length v15, v6

    move/from16 v0, p1

    invoke-static {v6, v14, v15, v0}, Lcom/aio/downloader/utils/MyBase64;->decode([BIII)[B

    move-result-object v6

    .line 1397
    and-int/lit8 v14, p1, 0x4

    if-eqz v14, :cond_2

    const/4 v7, 0x1

    .line 1398
    .local v7, "dontGunzip":Z
    :goto_1
    if-eqz v6, :cond_1

    array-length v14, v6

    const/4 v15, 0x4

    if-lt v14, v15, :cond_1

    if-nez v7, :cond_1

    .line 1400
    const/4 v14, 0x0

    aget-byte v14, v6, v14

    and-int/lit16 v14, v14, 0xff

    const/4 v15, 0x1

    aget-byte v15, v6, v15

    shl-int/lit8 v15, v15, 0x8

    const v16, 0xff00

    and-int v15, v15, v16

    or-int v11, v14, v15

    .line 1401
    .local v11, "head":I
    const v14, 0x8b1f

    if-ne v14, v11, :cond_1

    .line 1402
    const/4 v1, 0x0

    .line 1403
    .local v1, "bais":Ljava/io/ByteArrayInputStream;
    const/4 v9, 0x0

    .line 1404
    .local v9, "gzis":Ljava/util/zip/GZIPInputStream;
    const/4 v3, 0x0

    .line 1405
    .local v3, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v14, 0x800

    new-array v5, v14, [B

    .line 1406
    .local v5, "buffer":[B
    const/4 v12, 0x0

    .line 1409
    .local v12, "length":I
    :try_start_1
    new-instance v4, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v4}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_b
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1410
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v4, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_2
    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-direct {v2, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_c
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1411
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .local v2, "bais":Ljava/io/ByteArrayInputStream;
    :try_start_3
    new-instance v10, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v10, v2}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_d
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1413
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .local v10, "gzis":Ljava/util/zip/GZIPInputStream;
    :goto_2
    :try_start_4
    invoke-virtual {v10, v5}, Ljava/util/zip/GZIPInputStream;->read([B)I

    move-result v12

    if-gez v12, :cond_3

    .line 1418
    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result-object v6

    .line 1427
    :try_start_5
    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_8

    .line 1431
    :goto_3
    :try_start_6
    invoke-virtual {v10}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_9

    .line 1435
    :goto_4
    :try_start_7
    invoke-virtual {v2}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_a

    .line 1443
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "buffer":[B
    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .end local v11    # "head":I
    .end local v12    # "length":I
    :cond_1
    :goto_5
    return-object v6

    .line 1387
    .end local v6    # "bytes":[B
    .end local v7    # "dontGunzip":Z
    :catch_0
    move-exception v13

    .line 1388
    .local v13, "uee":Ljava/io/UnsupportedEncodingException;
    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    .restart local v6    # "bytes":[B
    goto :goto_0

    .line 1397
    .end local v13    # "uee":Ljava/io/UnsupportedEncodingException;
    :cond_2
    const/4 v7, 0x0

    goto :goto_1

    .line 1414
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "buffer":[B
    .restart local v7    # "dontGunzip":Z
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v11    # "head":I
    .restart local v12    # "length":I
    :cond_3
    const/4 v14, 0x0

    :try_start_8
    invoke-virtual {v4, v5, v14, v12}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_1
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    goto :goto_2

    .line 1421
    :catch_1
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .line 1422
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .local v8, "e":Ljava/io/IOException;
    :goto_6
    :try_start_9
    invoke-virtual {v8}, Ljava/io/IOException;->printStackTrace()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 1427
    :try_start_a
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3

    .line 1431
    :goto_7
    :try_start_b
    invoke-virtual {v9}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_4

    .line 1435
    :goto_8
    :try_start_c
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_2

    goto :goto_5

    .line 1436
    :catch_2
    move-exception v14

    goto :goto_5

    .line 1425
    .end local v8    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v14

    .line 1427
    :goto_9
    :try_start_d
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_5

    .line 1431
    :goto_a
    :try_start_e
    invoke-virtual {v9}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_6

    .line 1435
    :goto_b
    :try_start_f
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_7

    .line 1438
    :goto_c
    throw v14

    .line 1428
    .restart local v8    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v14

    goto :goto_7

    .line 1432
    :catch_4
    move-exception v14

    goto :goto_8

    .line 1428
    .end local v8    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v15

    goto :goto_a

    .line 1432
    :catch_6
    move-exception v15

    goto :goto_b

    .line 1436
    :catch_7
    move-exception v15

    goto :goto_c

    .line 1428
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catch_8
    move-exception v14

    goto :goto_3

    .line 1432
    :catch_9
    move-exception v14

    goto :goto_4

    .line 1436
    :catch_a
    move-exception v14

    goto :goto_5

    .line 1425
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catchall_1
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_9

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_9

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catchall_3
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_9

    .line 1421
    :catch_b
    move-exception v8

    goto :goto_6

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_c
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_6

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_d
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_6
.end method

.method public static decode([B)[B
    .locals 3
    .param p0, "source"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1244
    const/4 v0, 0x0

    .line 1246
    .local v0, "decoded":[B
    array-length v1, p0

    invoke-static {p0, v2, v1, v2}, Lcom/aio/downloader/utils/MyBase64;->decode([BIII)[B

    move-result-object v0

    .line 1252
    return-object v0
.end method

.method public static decode([BIII)[B
    .locals 16
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1280
    if-nez p0, :cond_0

    .line 1281
    new-instance v11, Ljava/lang/NullPointerException;

    const-string v12, "Cannot decode null source array."

    invoke-direct {v11, v12}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1283
    :cond_0
    if-ltz p1, :cond_1

    add-int v11, p1, p2

    move-object/from16 v0, p0

    array-length v12, v0

    if-le v11, v12, :cond_2

    .line 1284
    :cond_1
    new-instance v11, Ljava/lang/IllegalArgumentException;

    .line 1286
    const-string v12, "Source array with length %d cannot have offset of %d and process %d bytes."

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    .line 1287
    move-object/from16 v0, p0

    array-length v15, v0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x2

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    .line 1285
    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    .line 1284
    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1290
    :cond_2
    if-nez p2, :cond_3

    .line 1291
    const/4 v11, 0x0

    new-array v7, v11, [B

    .line 1343
    :goto_0
    return-object v7

    .line 1292
    :cond_3
    const/4 v11, 0x4

    move/from16 v0, p2

    if-ge v0, v11, :cond_4

    .line 1293
    new-instance v11, Ljava/lang/IllegalArgumentException;

    .line 1294
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "Base64-encoded string must have at least four characters, but length specified was "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1295
    move/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    .line 1294
    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 1293
    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1298
    :cond_4
    invoke-static/range {p3 .. p3}, Lcom/aio/downloader/utils/MyBase64;->getDecodabet(I)[B

    move-result-object v1

    .line 1300
    .local v1, "DECODABET":[B
    mul-int/lit8 v11, p2, 0x3

    div-int/lit8 v6, v11, 0x4

    .line 1301
    .local v6, "len34":I
    new-array v8, v6, [B

    .line 1302
    .local v8, "outBuff":[B
    const/4 v9, 0x0

    .line 1304
    .local v9, "outBuffPosn":I
    const/4 v11, 0x4

    new-array v2, v11, [B

    .line 1306
    .local v2, "b4":[B
    const/4 v3, 0x0

    .line 1307
    .local v3, "b4Posn":I
    const/4 v5, 0x0

    .line 1308
    .local v5, "i":I
    const/4 v10, 0x0

    .line 1310
    .local v10, "sbiDecode":B
    move/from16 v5, p1

    move v4, v3

    .end local v3    # "b4Posn":I
    .local v4, "b4Posn":I
    :goto_1
    add-int v11, p1, p2

    if-lt v5, v11, :cond_6

    move v3, v4

    .line 1341
    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    :cond_5
    new-array v7, v9, [B

    .line 1342
    .local v7, "out":[B
    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v8, v11, v7, v12, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 1312
    .end local v3    # "b4Posn":I
    .end local v7    # "out":[B
    .restart local v4    # "b4Posn":I
    :cond_6
    aget-byte v11, p0, v5

    and-int/lit16 v11, v11, 0xff

    aget-byte v10, v1, v11

    .line 1317
    const/4 v11, -0x5

    if-lt v10, v11, :cond_8

    .line 1318
    const/4 v11, -0x1

    if-lt v10, v11, :cond_9

    .line 1319
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    aget-byte v11, p0, v5

    aput-byte v11, v2, v4

    .line 1320
    const/4 v11, 0x3

    if-le v3, v11, :cond_7

    .line 1321
    const/4 v11, 0x0

    .line 1322
    move/from16 v0, p3

    invoke-static {v2, v11, v8, v9, v0}, Lcom/aio/downloader/utils/MyBase64;->decode4to3([BI[BII)I

    move-result v11

    add-int/2addr v9, v11

    .line 1323
    const/4 v3, 0x0

    .line 1326
    aget-byte v11, p0, v5

    const/16 v12, 0x3d

    if-eq v11, v12, :cond_5

    .line 1310
    :cond_7
    :goto_2
    add-int/lit8 v5, v5, 0x1

    move v4, v3

    .end local v3    # "b4Posn":I
    .restart local v4    # "b4Posn":I
    goto :goto_1

    .line 1334
    :cond_8
    new-instance v11, Ljava/io/IOException;

    .line 1336
    const-string v12, "Bad Base64 input character decimal %d in array position %d"

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    .line 1337
    aget-byte v15, p0, v5

    and-int/lit16 v15, v15, 0xff

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    .line 1335
    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    .line 1334
    invoke-direct {v11, v12}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v11

    :cond_9
    move v3, v4

    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    goto :goto_2
.end method

.method private static decode4to3([BI[BII)I
    .locals 8
    .param p0, "source"    # [B
    .param p1, "srcOffset"    # I
    .param p2, "destination"    # [B
    .param p3, "destOffset"    # I
    .param p4, "options"    # I

    .prologue
    const/16 v6, 0x3d

    const/4 v7, 0x0

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 1159
    if-nez p0, :cond_0

    .line 1160
    new-instance v2, Ljava/lang/NullPointerException;

    const-string v3, "Source array was null."

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1162
    :cond_0
    if-nez p2, :cond_1

    .line 1163
    new-instance v2, Ljava/lang/NullPointerException;

    const-string v3, "Destination array was null."

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1165
    :cond_1
    if-ltz p1, :cond_2

    add-int/lit8 v4, p1, 0x3

    array-length v5, p0

    if-lt v4, v5, :cond_3

    .line 1166
    :cond_2
    new-instance v4, Ljava/lang/IllegalArgumentException;

    .line 1168
    const-string v5, "Source array with length %d cannot have offset of %d and still process four bytes."

    new-array v3, v3, [Ljava/lang/Object;

    .line 1169
    array-length v6, p0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v7

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v2

    .line 1167
    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1166
    invoke-direct {v4, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1171
    :cond_3
    if-ltz p3, :cond_4

    add-int/lit8 v4, p3, 0x2

    array-length v5, p2

    if-lt v4, v5, :cond_5

    .line 1172
    :cond_4
    new-instance v4, Ljava/lang/IllegalArgumentException;

    .line 1174
    const-string v5, "Destination array with length %d cannot have offset of %d and still store three bytes."

    new-array v3, v3, [Ljava/lang/Object;

    .line 1175
    array-length v6, p2

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v7

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v2

    .line 1173
    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1172
    invoke-direct {v4, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1178
    :cond_5
    invoke-static {p4}, Lcom/aio/downloader/utils/MyBase64;->getDecodabet(I)[B

    move-result-object v0

    .line 1181
    .local v0, "DECODABET":[B
    add-int/lit8 v4, p1, 0x2

    aget-byte v4, p0, v4

    if-ne v4, v6, :cond_6

    .line 1186
    aget-byte v3, p0, p1

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x12

    .line 1187
    add-int/lit8 v4, p1, 0x1

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0xc

    .line 1186
    or-int v1, v3, v4

    .line 1189
    .local v1, "outBuff":I
    ushr-int/lit8 v3, v1, 0x10

    int-to-byte v3, v3

    aput-byte v3, p2, p3

    .line 1226
    :goto_0
    return v2

    .line 1194
    .end local v1    # "outBuff":I
    :cond_6
    add-int/lit8 v2, p1, 0x3

    aget-byte v2, p0, v2

    if-ne v2, v6, :cond_7

    .line 1200
    aget-byte v2, p0, p1

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x12

    .line 1201
    add-int/lit8 v4, p1, 0x1

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0xc

    .line 1200
    or-int/2addr v2, v4

    .line 1202
    add-int/lit8 v4, p1, 0x2

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x6

    .line 1200
    or-int v1, v2, v4

    .line 1204
    .restart local v1    # "outBuff":I
    ushr-int/lit8 v2, v1, 0x10

    int-to-byte v2, v2

    aput-byte v2, p2, p3

    .line 1205
    add-int/lit8 v2, p3, 0x1

    ushr-int/lit8 v4, v1, 0x8

    int-to-byte v4, v4

    aput-byte v4, p2, v2

    move v2, v3

    .line 1206
    goto :goto_0

    .line 1217
    .end local v1    # "outBuff":I
    :cond_7
    aget-byte v2, p0, p1

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x12

    .line 1218
    add-int/lit8 v3, p1, 0x1

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0xc

    .line 1217
    or-int/2addr v2, v3

    .line 1219
    add-int/lit8 v3, p1, 0x2

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x6

    .line 1217
    or-int/2addr v2, v3

    .line 1220
    add-int/lit8 v3, p1, 0x3

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1217
    or-int v1, v2, v3

    .line 1222
    .restart local v1    # "outBuff":I
    shr-int/lit8 v2, v1, 0x10

    int-to-byte v2, v2

    aput-byte v2, p2, p3

    .line 1223
    add-int/lit8 v2, p3, 0x1

    shr-int/lit8 v3, v1, 0x8

    int-to-byte v3, v3

    aput-byte v3, p2, v2

    .line 1224
    add-int/lit8 v2, p3, 0x2

    int-to-byte v3, v1

    aput-byte v3, p2, v2

    .line 1226
    const/4 v2, 0x3

    goto :goto_0
.end method

.method public static decodeFileToFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "infile"    # Ljava/lang/String;
    .param p1, "outfile"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1801
    invoke-static {p0}, Lcom/aio/downloader/utils/MyBase64;->decodeFromFile(Ljava/lang/String;)[B

    move-result-object v0

    .line 1802
    .local v0, "decoded":[B
    const/4 v2, 0x0

    .line 1804
    .local v2, "out":Ljava/io/OutputStream;
    :try_start_0
    new-instance v3, Ljava/io/BufferedOutputStream;

    .line 1805
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 1804
    invoke-direct {v3, v4}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1806
    .end local v2    # "out":Ljava/io/OutputStream;
    .local v3, "out":Ljava/io/OutputStream;
    :try_start_1
    invoke-virtual {v3, v0}, Ljava/io/OutputStream;->write([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1813
    :try_start_2
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1817
    :goto_0
    return-void

    .line 1808
    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    :catch_0
    move-exception v1

    .line 1809
    .local v1, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1811
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 1813
    :goto_2
    :try_start_4
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 1816
    :goto_3
    throw v4

    .line 1814
    :catch_1
    move-exception v5

    goto :goto_3

    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v3    # "out":Ljava/io/OutputStream;
    :catch_2
    move-exception v4

    goto :goto_0

    .line 1811
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    goto :goto_2

    .line 1808
    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v3    # "out":Ljava/io/OutputStream;
    :catch_3
    move-exception v1

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    goto :goto_1
.end method

.method public static decodeFromFile(Ljava/lang/String;)[B
    .locals 12
    .param p0, "filename"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1653
    const/4 v3, 0x0

    .line 1654
    .local v3, "decodedData":[B
    const/4 v0, 0x0

    .line 1657
    .local v0, "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :try_start_0
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1658
    .local v5, "file":Ljava/io/File;
    const/4 v2, 0x0

    .line 1659
    .local v2, "buffer":[B
    const/4 v6, 0x0

    .line 1660
    .local v6, "length":I
    const/4 v7, 0x0

    .line 1663
    .local v7, "numBytes":I
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v8

    const-wide/32 v10, 0x7fffffff

    cmp-long v8, v8, v10

    if-lez v8, :cond_0

    .line 1664
    new-instance v8, Ljava/io/IOException;

    .line 1665
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "File is too big for this convenience method ("

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1666
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v10

    invoke-virtual {v9, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " bytes)."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 1665
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 1664
    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1684
    .end local v2    # "buffer":[B
    .end local v5    # "file":Ljava/io/File;
    .end local v6    # "length":I
    .end local v7    # "numBytes":I
    :catch_0
    move-exception v4

    .line 1685
    .local v4, "e":Ljava/io/IOException;
    :goto_0
    :try_start_1
    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1687
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    .line 1689
    :goto_1
    :try_start_2
    invoke-virtual {v0}, Lcom/aio/downloader/utils/MyBase64$InputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 1692
    :goto_2
    throw v8

    .line 1668
    .restart local v2    # "buffer":[B
    .restart local v5    # "file":Ljava/io/File;
    .restart local v6    # "length":I
    .restart local v7    # "numBytes":I
    :cond_0
    :try_start_3
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v8

    long-to-int v8, v8

    new-array v2, v8, [B

    .line 1671
    new-instance v1, Lcom/aio/downloader/utils/MyBase64$InputStream;

    new-instance v8, Ljava/io/BufferedInputStream;

    .line 1672
    new-instance v9, Ljava/io/FileInputStream;

    invoke-direct {v9, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v8, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    const/4 v9, 0x0

    .line 1671
    invoke-direct {v1, v8, v9}, Lcom/aio/downloader/utils/MyBase64$InputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1675
    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .local v1, "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :goto_3
    const/16 v8, 0x1000

    :try_start_4
    invoke-virtual {v1, v2, v6, v8}, Lcom/aio/downloader/utils/MyBase64$InputStream;->read([BII)I

    move-result v7

    if-gez v7, :cond_1

    .line 1680
    new-array v3, v6, [B

    .line 1681
    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-static {v2, v8, v3, v9, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1689
    :try_start_5
    invoke-virtual {v1}, Lcom/aio/downloader/utils/MyBase64$InputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    .line 1694
    :goto_4
    return-object v3

    .line 1676
    :cond_1
    add-int/2addr v6, v7

    goto :goto_3

    .line 1690
    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .end local v2    # "buffer":[B
    .end local v5    # "file":Ljava/io/File;
    .end local v6    # "length":I
    .end local v7    # "numBytes":I
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :catch_1
    move-exception v9

    goto :goto_2

    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v2    # "buffer":[B
    .restart local v5    # "file":Ljava/io/File;
    .restart local v6    # "length":I
    .restart local v7    # "numBytes":I
    :catch_2
    move-exception v8

    goto :goto_4

    .line 1687
    :catchall_1
    move-exception v8

    move-object v0, v1

    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    goto :goto_1

    .line 1684
    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :catch_3
    move-exception v4

    move-object v0, v1

    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    goto :goto_0
.end method

.method public static decodeToFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "dataToDecode"    # Ljava/lang/String;
    .param p1, "filename"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1615
    const/4 v0, 0x0

    .line 1617
    .local v0, "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_0
    new-instance v1, Lcom/aio/downloader/utils/MyBase64$OutputStream;

    .line 1618
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x0

    .line 1617
    invoke-direct {v1, v3, v4}, Lcom/aio/downloader/utils/MyBase64$OutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1619
    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .local v1, "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_1
    const-string v3, "US-ASCII"

    invoke-virtual {p0, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->write([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1626
    :try_start_2
    invoke-virtual {v1}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1631
    :goto_0
    return-void

    .line 1621
    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_0
    move-exception v2

    .line 1622
    .local v2, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1624
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    .line 1626
    :goto_2
    :try_start_4
    invoke-virtual {v0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 1629
    :goto_3
    throw v3

    .line 1627
    :catch_1
    move-exception v4

    goto :goto_3

    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_2
    move-exception v3

    goto :goto_0

    .line 1624
    :catchall_1
    move-exception v3

    move-object v0, v1

    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    goto :goto_2

    .line 1621
    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_3
    move-exception v2

    move-object v0, v1

    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    goto :goto_1
.end method

.method public static decodeToObject(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p0, "encodedObject"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 1464
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/aio/downloader/utils/MyBase64;->decodeToObject(Ljava/lang/String;ILjava/lang/ClassLoader;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static decodeToObject(Ljava/lang/String;ILjava/lang/ClassLoader;)Ljava/lang/Object;
    .locals 9
    .param p0, "encodedObject"    # Ljava/lang/String;
    .param p1, "options"    # I
    .param p2, "loader"    # Ljava/lang/ClassLoader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 1493
    invoke-static {p0, p1}, Lcom/aio/downloader/utils/MyBase64;->decode(Ljava/lang/String;I)[B

    move-result-object v4

    .line 1495
    .local v4, "objBytes":[B
    const/4 v0, 0x0

    .line 1496
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    const/4 v5, 0x0

    .line 1497
    .local v5, "ois":Ljava/io/ObjectInputStream;
    const/4 v3, 0x0

    .line 1500
    .local v3, "obj":Ljava/lang/Object;
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1503
    .end local v0    # "bais":Ljava/io/ByteArrayInputStream;
    .local v1, "bais":Ljava/io/ByteArrayInputStream;
    if-nez p2, :cond_0

    .line 1504
    :try_start_1
    new-instance v6, Ljava/io/ObjectInputStream;

    invoke-direct {v6, v1}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .end local v5    # "ois":Ljava/io/ObjectInputStream;
    .local v6, "ois":Ljava/io/ObjectInputStream;
    move-object v5, v6

    .line 1527
    .end local v6    # "ois":Ljava/io/ObjectInputStream;
    .restart local v5    # "ois":Ljava/io/ObjectInputStream;
    :goto_0
    invoke-virtual {v5}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v3

    .line 1537
    :try_start_2
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4

    .line 1541
    :goto_1
    :try_start_3
    invoke-virtual {v5}, Ljava/io/ObjectInputStream;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_5

    .line 1546
    :goto_2
    return-object v3

    .line 1510
    :cond_0
    :try_start_4
    new-instance v6, Lcom/aio/downloader/utils/MyBase64$1;

    invoke-direct {v6, v1, p2}, Lcom/aio/downloader/utils/MyBase64$1;-><init>(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4 .. :try_end_4} :catch_6
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .end local v5    # "ois":Ljava/io/ObjectInputStream;
    .restart local v6    # "ois":Ljava/io/ObjectInputStream;
    move-object v5, v6

    .end local v6    # "ois":Ljava/io/ObjectInputStream;
    .restart local v5    # "ois":Ljava/io/ObjectInputStream;
    goto :goto_0

    .line 1529
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v0    # "bais":Ljava/io/ByteArrayInputStream;
    :catch_0
    move-exception v2

    .line 1530
    .local v2, "e":Ljava/io/IOException;
    :goto_3
    :try_start_5
    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1535
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    .line 1537
    :goto_4
    :try_start_6
    invoke-virtual {v0}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    .line 1541
    :goto_5
    :try_start_7
    invoke-virtual {v5}, Ljava/io/ObjectInputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    .line 1544
    :goto_6
    throw v7

    .line 1532
    :catch_1
    move-exception v2

    .line 1533
    .local v2, "e":Ljava/lang/ClassNotFoundException;
    :goto_7
    :try_start_8
    throw v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 1538
    .end local v2    # "e":Ljava/lang/ClassNotFoundException;
    :catch_2
    move-exception v8

    goto :goto_5

    .line 1542
    :catch_3
    move-exception v8

    goto :goto_6

    .line 1538
    .end local v0    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    :catch_4
    move-exception v7

    goto :goto_1

    .line 1542
    :catch_5
    move-exception v7

    goto :goto_2

    .line 1535
    :catchall_1
    move-exception v7

    move-object v0, v1

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v0    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_4

    .line 1532
    .end local v0    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    :catch_6
    move-exception v2

    move-object v0, v1

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v0    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_7

    .line 1529
    .end local v0    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    :catch_7
    move-exception v2

    move-object v0, v1

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v0    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_3
.end method

.method public static encode(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
    .locals 6
    .param p0, "raw"    # Ljava/nio/ByteBuffer;
    .param p1, "encoded"    # Ljava/nio/ByteBuffer;

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x0

    .line 620
    new-array v1, v5, [B

    .line 621
    .local v1, "raw3":[B
    const/4 v3, 0x4

    new-array v0, v3, [B

    .line 623
    .local v0, "enc4":[B
    :goto_0
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v3

    if-nez v3, :cond_0

    .line 629
    return-void

    .line 624
    :cond_0
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    invoke-static {v5, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 625
    .local v2, "rem":I
    invoke-virtual {p0, v1, v4, v2}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 626
    invoke-static {v0, v1, v2, v4}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([B[BII)[B

    .line 627
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    goto :goto_0
.end method

.method public static encode(Ljava/nio/ByteBuffer;Ljava/nio/CharBuffer;)V
    .locals 8
    .param p0, "raw"    # Ljava/nio/ByteBuffer;
    .param p1, "encoded"    # Ljava/nio/CharBuffer;

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x0

    .line 645
    new-array v2, v6, [B

    .line 646
    .local v2, "raw3":[B
    new-array v0, v7, [B

    .line 648
    .local v0, "enc4":[B
    :cond_0
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v4

    if-nez v4, :cond_1

    .line 656
    return-void

    .line 649
    :cond_1
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    invoke-static {v6, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 650
    .local v3, "rem":I
    invoke-virtual {p0, v2, v5, v3}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 651
    invoke-static {v0, v2, v3, v5}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([B[BII)[B

    .line 652
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v7, :cond_0

    .line 653
    aget-byte v4, v0, v1

    and-int/lit16 v4, v4, 0xff

    int-to-char v4, v4

    invoke-virtual {p1, v4}, Ljava/nio/CharBuffer;->put(C)Ljava/nio/CharBuffer;

    .line 652
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private static encode3to4([BII[BII)[B
    .locals 6
    .param p0, "source"    # [B
    .param p1, "srcOffset"    # I
    .param p2, "numSigBytes"    # I
    .param p3, "destination"    # [B
    .param p4, "destOffset"    # I
    .param p5, "options"    # I

    .prologue
    const/16 v5, 0x3d

    const/4 v2, 0x0

    .line 561
    invoke-static {p5}, Lcom/aio/downloader/utils/MyBase64;->getAlphabet(I)[B

    move-result-object v0

    .line 575
    .local v0, "ALPHABET":[B
    if-lez p2, :cond_1

    aget-byte v3, p0, p1

    shl-int/lit8 v3, v3, 0x18

    ushr-int/lit8 v3, v3, 0x8

    move v4, v3

    .line 576
    :goto_0
    const/4 v3, 0x1

    if-le p2, v3, :cond_2

    add-int/lit8 v3, p1, 0x1

    aget-byte v3, p0, v3

    shl-int/lit8 v3, v3, 0x18

    ushr-int/lit8 v3, v3, 0x10

    .line 575
    :goto_1
    or-int/2addr v3, v4

    .line 577
    const/4 v4, 0x2

    if-le p2, v4, :cond_0

    add-int/lit8 v2, p1, 0x2

    aget-byte v2, p0, v2

    shl-int/lit8 v2, v2, 0x18

    ushr-int/lit8 v2, v2, 0x18

    .line 575
    :cond_0
    or-int v1, v3, v2

    .line 579
    .local v1, "inBuff":I
    packed-switch p2, :pswitch_data_0

    .line 602
    :goto_2
    return-object p3

    .end local v1    # "inBuff":I
    :cond_1
    move v4, v2

    .line 575
    goto :goto_0

    :cond_2
    move v3, v2

    .line 576
    goto :goto_1

    .line 581
    .restart local v1    # "inBuff":I
    :pswitch_0
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 582
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 583
    add-int/lit8 v2, p4, 0x2

    ushr-int/lit8 v3, v1, 0x6

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 584
    add-int/lit8 v2, p4, 0x3

    and-int/lit8 v3, v1, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    goto :goto_2

    .line 588
    :pswitch_1
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 589
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 590
    add-int/lit8 v2, p4, 0x2

    ushr-int/lit8 v3, v1, 0x6

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 591
    add-int/lit8 v2, p4, 0x3

    aput-byte v5, p3, v2

    goto :goto_2

    .line 595
    :pswitch_2
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 596
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 597
    add-int/lit8 v2, p4, 0x2

    aput-byte v5, p3, v2

    .line 598
    add-int/lit8 v2, p4, 0x3

    aput-byte v5, p3, v2

    goto :goto_2

    .line 579
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static encode3to4([B[BII)[B
    .locals 6
    .param p0, "b4"    # [B
    .param p1, "threeBytes"    # [B
    .param p2, "numSigBytes"    # I
    .param p3, "options"    # I

    .prologue
    const/4 v1, 0x0

    .line 524
    move-object v0, p1

    move v2, p2

    move-object v3, p0

    move v4, v1

    move v5, p3

    invoke-static/range {v0 .. v5}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([BII[BII)[B

    .line 525
    return-object p0
.end method

.method public static encodeBytes([B)Ljava/lang/String;
    .locals 5
    .param p0, "source"    # [B

    .prologue
    .line 797
    const/4 v0, 0x0

    .line 799
    .local v0, "encoded":Ljava/lang/String;
    const/4 v2, 0x0

    :try_start_0
    array-length v3, p0

    const/4 v4, 0x0

    invoke-static {p0, v2, v3, v4}, Lcom/aio/downloader/utils/MyBase64;->encodeBytes([BIII)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 803
    :cond_0
    sget-boolean v2, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    if-nez v2, :cond_1

    if-nez v0, :cond_1

    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2}, Ljava/lang/AssertionError;-><init>()V

    throw v2

    .line 800
    :catch_0
    move-exception v1

    .line 801
    .local v1, "ex":Ljava/io/IOException;
    sget-boolean v2, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/AssertionError;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 804
    .end local v1    # "ex":Ljava/io/IOException;
    :cond_1
    return-object v0
.end method

.method public static encodeBytes([BI)Ljava/lang/String;
    .locals 2
    .param p0, "source"    # [B
    .param p1, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 847
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lcom/aio/downloader/utils/MyBase64;->encodeBytes([BIII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encodeBytes([BII)Ljava/lang/String;
    .locals 4
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I

    .prologue
    .line 878
    const/4 v0, 0x0

    .line 880
    .local v0, "encoded":Ljava/lang/String;
    const/4 v2, 0x0

    :try_start_0
    invoke-static {p0, p1, p2, v2}, Lcom/aio/downloader/utils/MyBase64;->encodeBytes([BIII)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 884
    :cond_0
    sget-boolean v2, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    if-nez v2, :cond_1

    if-nez v0, :cond_1

    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2}, Ljava/lang/AssertionError;-><init>()V

    throw v2

    .line 881
    :catch_0
    move-exception v1

    .line 882
    .local v1, "ex":Ljava/io/IOException;
    sget-boolean v2, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/AssertionError;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 885
    .end local v1    # "ex":Ljava/io/IOException;
    :cond_1
    return-object v0
.end method

.method public static encodeBytes([BIII)Ljava/lang/String;
    .locals 4
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 934
    invoke-static {p0, p1, p2, p3}, Lcom/aio/downloader/utils/MyBase64;->encodeBytesToBytes([BIII)[B

    move-result-object v0

    .line 938
    .local v0, "encoded":[B
    :try_start_0
    new-instance v2, Ljava/lang/String;

    const-string v3, "US-ASCII"

    invoke-direct {v2, v0, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 941
    :goto_0
    return-object v2

    .line 940
    :catch_0
    move-exception v1

    .line 941
    .local v1, "uue":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([B)V

    goto :goto_0
.end method

.method public static encodeBytesToBytes([B)[B
    .locals 5
    .param p0, "source"    # [B

    .prologue
    .line 960
    const/4 v0, 0x0

    .line 962
    .local v0, "encoded":[B
    const/4 v2, 0x0

    :try_start_0
    array-length v3, p0

    .line 963
    const/4 v4, 0x0

    .line 962
    invoke-static {p0, v2, v3, v4}, Lcom/aio/downloader/utils/MyBase64;->encodeBytesToBytes([BIII)[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 968
    :cond_0
    return-object v0

    .line 964
    :catch_0
    move-exception v1

    .line 965
    .local v1, "ex":Ljava/io/IOException;
    sget-boolean v2, Lcom/aio/downloader/utils/MyBase64;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/AssertionError;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "IOExceptions only come from GZipping, which is turned off: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 966
    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2
.end method

.method public static encodeBytesToBytes([BIII)[B
    .locals 23
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 999
    if-nez p0, :cond_0

    .line 1000
    new-instance v4, Ljava/lang/NullPointerException;

    const-string v5, "Cannot serialize a null array."

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1003
    :cond_0
    if-gez p1, :cond_1

    .line 1004
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Cannot have negative offset: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1005
    move/from16 v0, p1

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1004
    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1008
    :cond_1
    if-gez p2, :cond_2

    .line 1009
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Cannot have length offset: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1010
    move/from16 v0, p2

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1009
    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1013
    :cond_2
    add-int v4, p1, p2

    move-object/from16 v0, p0

    array-length v5, v0

    if-le v4, v5, :cond_3

    .line 1014
    new-instance v4, Ljava/lang/IllegalArgumentException;

    .line 1016
    const-string v5, "Cannot have offset of %d and length of %d with array of length %d"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v9, 0x0

    .line 1017
    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    const/4 v9, 0x1

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    const/4 v9, 0x2

    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v22, v0

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    .line 1015
    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 1014
    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1021
    :cond_3
    and-int/lit8 v4, p3, 0x2

    if-eqz v4, :cond_4

    .line 1022
    const/4 v12, 0x0

    .line 1023
    .local v12, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v18, 0x0

    .line 1024
    .local v18, "gzos":Ljava/util/zip/GZIPOutputStream;
    const/4 v10, 0x0

    .line 1028
    .local v10, "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_0
    new-instance v13, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v13}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1029
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v13, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v11, Lcom/aio/downloader/utils/MyBase64$OutputStream;

    or-int/lit8 v4, p3, 0x1

    invoke-direct {v11, v13, v4}, Lcom/aio/downloader/utils/MyBase64$OutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1030
    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .local v11, "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_2
    new-instance v19, Ljava/util/zip/GZIPOutputStream;

    move-object/from16 v0, v19

    invoke-direct {v0, v11}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_8
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 1032
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .local v19, "gzos":Ljava/util/zip/GZIPOutputStream;
    :try_start_3
    move-object/from16 v0, v19

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/zip/GZIPOutputStream;->write([BII)V

    .line 1033
    invoke-virtual/range {v19 .. v19}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_9
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 1042
    :try_start_4
    invoke-virtual/range {v19 .. v19}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 1046
    :goto_0
    :try_start_5
    invoke-virtual {v11}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 1050
    :goto_1
    :try_start_6
    invoke-virtual {v13}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    .line 1055
    :goto_2
    invoke-virtual {v13}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v17

    .line 1111
    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :goto_3
    return-object v17

    .line 1035
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_0
    move-exception v8

    .line 1038
    .local v8, "e":Ljava/io/IOException;
    :goto_4
    :try_start_7
    throw v8
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 1040
    .end local v8    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 1042
    :goto_5
    :try_start_8
    invoke-virtual/range {v18 .. v18}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_1

    .line 1046
    :goto_6
    :try_start_9
    invoke-virtual {v10}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2

    .line 1050
    :goto_7
    :try_start_a
    invoke-virtual {v12}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3

    .line 1053
    :goto_8
    throw v4

    .line 1060
    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :cond_4
    and-int/lit8 v4, p3, 0x8

    if-eqz v4, :cond_7

    const/4 v14, 0x1

    .line 1069
    .local v14, "breakLines":Z
    :goto_9
    div-int/lit8 v4, p2, 0x3

    mul-int/lit8 v5, v4, 0x4

    rem-int/lit8 v4, p2, 0x3

    if-lez v4, :cond_8

    const/4 v4, 0x4

    :goto_a
    add-int v16, v5, v4

    .line 1072
    .local v16, "encLen":I
    if-eqz v14, :cond_5

    .line 1073
    div-int/lit8 v4, v16, 0x4c

    add-int v16, v16, v4

    .line 1076
    :cond_5
    move/from16 v0, v16

    new-array v7, v0, [B

    .line 1078
    .local v7, "outBuff":[B
    const/4 v15, 0x0

    .line 1079
    .local v15, "d":I
    const/4 v8, 0x0

    .line 1080
    .local v8, "e":I
    add-int/lit8 v20, p2, -0x2

    .line 1081
    .local v20, "len2":I
    const/16 v21, 0x0

    .line 1082
    .local v21, "lineLength":I
    :goto_b
    move/from16 v0, v20

    if-lt v15, v0, :cond_9

    .line 1093
    move/from16 v0, p2

    if-ge v15, v0, :cond_6

    .line 1094
    add-int v5, v15, p1

    sub-int v6, p2, v15

    move-object/from16 v4, p0

    move/from16 v9, p3

    invoke-static/range {v4 .. v9}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([BII[BII)[B

    .line 1095
    add-int/lit8 v8, v8, 0x4

    .line 1099
    :cond_6
    array-length v4, v7

    add-int/lit8 v4, v4, -0x1

    if-gt v8, v4, :cond_b

    .line 1104
    new-array v0, v8, [B

    move-object/from16 v17, v0

    .line 1105
    .local v17, "finalOut":[B
    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v17

    invoke-static {v7, v4, v0, v5, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_3

    .line 1060
    .end local v7    # "outBuff":[B
    .end local v8    # "e":I
    .end local v14    # "breakLines":Z
    .end local v15    # "d":I
    .end local v16    # "encLen":I
    .end local v17    # "finalOut":[B
    .end local v20    # "len2":I
    .end local v21    # "lineLength":I
    :cond_7
    const/4 v14, 0x0

    goto :goto_9

    .line 1069
    .restart local v14    # "breakLines":Z
    :cond_8
    const/4 v4, 0x0

    goto :goto_a

    .line 1083
    .restart local v7    # "outBuff":[B
    .restart local v8    # "e":I
    .restart local v15    # "d":I
    .restart local v16    # "encLen":I
    .restart local v20    # "len2":I
    .restart local v21    # "lineLength":I
    :cond_9
    add-int v5, v15, p1

    const/4 v6, 0x3

    move-object/from16 v4, p0

    move/from16 v9, p3

    invoke-static/range {v4 .. v9}, Lcom/aio/downloader/utils/MyBase64;->encode3to4([BII[BII)[B

    .line 1085
    add-int/lit8 v21, v21, 0x4

    .line 1086
    if-eqz v14, :cond_a

    const/16 v4, 0x4c

    move/from16 v0, v21

    if-lt v0, v4, :cond_a

    .line 1087
    add-int/lit8 v4, v8, 0x4

    const/16 v5, 0xa

    aput-byte v5, v7, v4

    .line 1088
    add-int/lit8 v8, v8, 0x1

    .line 1089
    const/16 v21, 0x0

    .line 1082
    :cond_a
    add-int/lit8 v15, v15, 0x3

    add-int/lit8 v8, v8, 0x4

    goto :goto_b

    :cond_b
    move-object/from16 v17, v7

    .line 1111
    goto :goto_3

    .line 1043
    .end local v7    # "outBuff":[B
    .end local v8    # "e":I
    .end local v14    # "breakLines":Z
    .end local v15    # "d":I
    .end local v16    # "encLen":I
    .end local v20    # "len2":I
    .end local v21    # "lineLength":I
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_1
    move-exception v5

    goto :goto_6

    .line 1047
    :catch_2
    move-exception v5

    goto :goto_7

    .line 1051
    :catch_3
    move-exception v5

    goto :goto_8

    .line 1043
    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_4
    move-exception v4

    goto/16 :goto_0

    .line 1047
    :catch_5
    move-exception v4

    goto/16 :goto_1

    .line 1051
    :catch_6
    move-exception v4

    goto/16 :goto_2

    .line 1040
    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catchall_1
    move-exception v4

    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v4

    move-object v10, v11

    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catchall_3
    move-exception v4

    move-object v10, v11

    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    move-object/from16 v18, v19

    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .line 1035
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_7
    move-exception v8

    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4

    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_8
    move-exception v8

    move-object v10, v11

    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4

    .end local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_9
    move-exception v8

    move-object v10, v11

    .end local v11    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v10    # "b64os":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    move-object/from16 v18, v19

    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4
.end method

.method public static encodeFileToFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "infile"    # Ljava/lang/String;
    .param p1, "outfile"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1769
    invoke-static {p0}, Lcom/aio/downloader/utils/MyBase64;->encodeFromFile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1770
    .local v1, "encoded":Ljava/lang/String;
    const/4 v2, 0x0

    .line 1772
    .local v2, "out":Ljava/io/OutputStream;
    :try_start_0
    new-instance v3, Ljava/io/BufferedOutputStream;

    .line 1773
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 1772
    invoke-direct {v3, v4}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1774
    .end local v2    # "out":Ljava/io/OutputStream;
    .local v3, "out":Ljava/io/OutputStream;
    :try_start_1
    const-string v4, "US-ASCII"

    invoke-virtual {v1, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/OutputStream;->write([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1781
    :try_start_2
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1785
    :goto_0
    return-void

    .line 1776
    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    :catch_0
    move-exception v0

    .line 1777
    .local v0, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1779
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 1781
    :goto_2
    :try_start_4
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 1784
    :goto_3
    throw v4

    .line 1782
    :catch_1
    move-exception v5

    goto :goto_3

    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v3    # "out":Ljava/io/OutputStream;
    :catch_2
    move-exception v4

    goto :goto_0

    .line 1779
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    goto :goto_2

    .line 1776
    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v3    # "out":Ljava/io/OutputStream;
    :catch_3
    move-exception v0

    move-object v2, v3

    .end local v3    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    goto :goto_1
.end method

.method public static encodeFromFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p0, "filename"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1717
    const/4 v4, 0x0

    .line 1718
    .local v4, "encodedData":Ljava/lang/String;
    const/4 v0, 0x0

    .line 1721
    .local v0, "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :try_start_0
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1722
    .local v5, "file":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v8

    long-to-double v8, v8

    const-wide v10, 0x3ff6666666666666L    # 1.4

    mul-double/2addr v8, v10

    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    add-double/2addr v8, v10

    double-to-int v8, v8

    .line 1723
    const/16 v9, 0x28

    .line 1722
    invoke-static {v8, v9}, Ljava/lang/Math;->max(II)I

    move-result v8

    new-array v2, v8, [B

    .line 1725
    .local v2, "buffer":[B
    const/4 v6, 0x0

    .line 1726
    .local v6, "length":I
    const/4 v7, 0x0

    .line 1729
    .local v7, "numBytes":I
    new-instance v1, Lcom/aio/downloader/utils/MyBase64$InputStream;

    new-instance v8, Ljava/io/BufferedInputStream;

    .line 1730
    new-instance v9, Ljava/io/FileInputStream;

    invoke-direct {v9, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v8, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    const/4 v9, 0x1

    .line 1729
    invoke-direct {v1, v8, v9}, Lcom/aio/downloader/utils/MyBase64$InputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1733
    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .local v1, "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :goto_0
    const/16 v8, 0x1000

    :try_start_1
    invoke-virtual {v1, v2, v6, v8}, Lcom/aio/downloader/utils/MyBase64$InputStream;->read([BII)I

    move-result v7

    if-gez v7, :cond_0

    .line 1738
    new-instance v4, Ljava/lang/String;

    .end local v4    # "encodedData":Ljava/lang/String;
    const/4 v8, 0x0

    .line 1739
    const-string v9, "US-ASCII"

    .line 1738
    invoke-direct {v4, v2, v8, v6, v9}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1747
    .restart local v4    # "encodedData":Ljava/lang/String;
    :try_start_2
    invoke-virtual {v1}, Lcom/aio/downloader/utils/MyBase64$InputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1752
    :goto_1
    return-object v4

    .line 1734
    :cond_0
    add-int/2addr v6, v7

    goto :goto_0

    .line 1742
    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .end local v2    # "buffer":[B
    .end local v5    # "file":Ljava/io/File;
    .end local v6    # "length":I
    .end local v7    # "numBytes":I
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :catch_0
    move-exception v3

    .line 1743
    .end local v4    # "encodedData":Ljava/lang/String;
    .local v3, "e":Ljava/io/IOException;
    :goto_2
    :try_start_3
    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1745
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    .line 1747
    :goto_3
    :try_start_4
    invoke-virtual {v0}, Lcom/aio/downloader/utils/MyBase64$InputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 1750
    :goto_4
    throw v8

    .line 1748
    :catch_1
    move-exception v9

    goto :goto_4

    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v2    # "buffer":[B
    .restart local v4    # "encodedData":Ljava/lang/String;
    .restart local v5    # "file":Ljava/io/File;
    .restart local v6    # "length":I
    .restart local v7    # "numBytes":I
    :catch_2
    move-exception v8

    goto :goto_1

    .line 1745
    .end local v4    # "encodedData":Ljava/lang/String;
    :catchall_1
    move-exception v8

    move-object v0, v1

    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    goto :goto_3

    .line 1742
    .end local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    :catch_3
    move-exception v3

    move-object v0, v1

    .end local v1    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    .restart local v0    # "bis":Lcom/aio/downloader/utils/MyBase64$InputStream;
    goto :goto_2
.end method

.method public static encodeObject(Ljava/io/Serializable;)Ljava/lang/String;
    .locals 1
    .param p0, "serializableObject"    # Ljava/io/Serializable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 682
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/aio/downloader/utils/MyBase64;->encodeObject(Ljava/io/Serializable;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encodeObject(Ljava/io/Serializable;I)Ljava/lang/String;
    .locals 13
    .param p0, "serializableObject"    # Ljava/io/Serializable;
    .param p1, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 724
    if-nez p0, :cond_0

    .line 725
    new-instance v10, Ljava/lang/NullPointerException;

    const-string v11, "Cannot serialize a null object."

    invoke-direct {v10, v11}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 729
    :cond_0
    const/4 v2, 0x0

    .line 730
    .local v2, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v0, 0x0

    .line 731
    .local v0, "b64os":Ljava/io/OutputStream;
    const/4 v5, 0x0

    .line 732
    .local v5, "gzos":Ljava/util/zip/GZIPOutputStream;
    const/4 v7, 0x0

    .line 736
    .local v7, "oos":Ljava/io/ObjectOutputStream;
    :try_start_0
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 737
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v3, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v1, Lcom/aio/downloader/utils/MyBase64$OutputStream;

    or-int/lit8 v10, p1, 0x1

    invoke-direct {v1, v3, v10}, Lcom/aio/downloader/utils/MyBase64$OutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_a
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 738
    .end local v0    # "b64os":Ljava/io/OutputStream;
    .local v1, "b64os":Ljava/io/OutputStream;
    and-int/lit8 v10, p1, 0x2

    if-eqz v10, :cond_1

    .line 740
    :try_start_2
    new-instance v6, Ljava/util/zip/GZIPOutputStream;

    invoke-direct {v6, v1}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_b
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 741
    .end local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .local v6, "gzos":Ljava/util/zip/GZIPOutputStream;
    :try_start_3
    new-instance v8, Ljava/io/ObjectOutputStream;

    invoke-direct {v8, v6}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_c
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .end local v7    # "oos":Ljava/io/ObjectOutputStream;
    .local v8, "oos":Ljava/io/ObjectOutputStream;
    move-object v7, v8

    .end local v8    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v7    # "oos":Ljava/io/ObjectOutputStream;
    move-object v5, v6

    .line 746
    .end local v6    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :goto_0
    :try_start_4
    invoke-virtual {v7, p0}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_b
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 755
    :try_start_5
    invoke-virtual {v7}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_6

    .line 759
    :goto_1
    :try_start_6
    invoke-virtual {v5}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_7

    .line 763
    :goto_2
    :try_start_7
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_8

    .line 767
    :goto_3
    :try_start_8
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_9

    .line 774
    :goto_4
    :try_start_9
    new-instance v10, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v11

    const-string v12, "US-ASCII"

    invoke-direct {v10, v11, v12}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_9
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_9 .. :try_end_9} :catch_1

    .line 778
    :goto_5
    return-object v10

    .line 744
    :cond_1
    :try_start_a
    new-instance v8, Ljava/io/ObjectOutputStream;

    invoke-direct {v8, v1}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_b
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    .end local v7    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v8    # "oos":Ljava/io/ObjectOutputStream;
    move-object v7, v8

    .end local v8    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v7    # "oos":Ljava/io/ObjectOutputStream;
    goto :goto_0

    .line 748
    .end local v1    # "b64os":Ljava/io/OutputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_0
    move-exception v4

    .line 751
    .local v4, "e":Ljava/io/IOException;
    :goto_6
    :try_start_b
    throw v4
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 753
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 755
    :goto_7
    :try_start_c
    invoke-virtual {v7}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_2

    .line 759
    :goto_8
    :try_start_d
    invoke-virtual {v5}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_3

    .line 763
    :goto_9
    :try_start_e
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_4

    .line 767
    :goto_a
    :try_start_f
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_5

    .line 770
    :goto_b
    throw v10

    .line 776
    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_1
    move-exception v9

    .line 778
    .local v9, "uue":Ljava/io/UnsupportedEncodingException;
    new-instance v10, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/String;-><init>([B)V

    goto :goto_5

    .line 756
    .end local v1    # "b64os":Ljava/io/OutputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "uue":Ljava/io/UnsupportedEncodingException;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_2
    move-exception v11

    goto :goto_8

    .line 760
    :catch_3
    move-exception v11

    goto :goto_9

    .line 764
    :catch_4
    move-exception v11

    goto :goto_a

    .line 768
    :catch_5
    move-exception v11

    goto :goto_b

    .line 756
    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_6
    move-exception v10

    goto :goto_1

    .line 760
    :catch_7
    move-exception v10

    goto :goto_2

    .line 764
    :catch_8
    move-exception v10

    goto :goto_3

    .line 768
    :catch_9
    move-exception v10

    goto :goto_4

    .line 753
    .end local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    :catchall_1
    move-exception v10

    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_7

    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v10

    move-object v0, v1

    .end local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_7

    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catchall_3
    move-exception v10

    move-object v5, v6

    .end local v6    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v0, v1

    .end local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_7

    .line 748
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_a
    move-exception v4

    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_6

    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_b
    move-exception v4

    move-object v0, v1

    .end local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_6

    .end local v0    # "b64os":Ljava/io/OutputStream;
    .end local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_c
    move-exception v4

    move-object v5, v6

    .end local v6    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v5    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v0, v1

    .end local v1    # "b64os":Ljava/io/OutputStream;
    .restart local v0    # "b64os":Ljava/io/OutputStream;
    move-object v2, v3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_6
.end method

.method public static encodeToFile([BLjava/lang/String;)V
    .locals 5
    .param p0, "dataToEncode"    # [B
    .param p1, "filename"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1572
    if-nez p0, :cond_0

    .line 1573
    new-instance v3, Ljava/lang/NullPointerException;

    const-string v4, "Data to encode was null."

    invoke-direct {v3, v4}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1576
    :cond_0
    const/4 v0, 0x0

    .line 1578
    .local v0, "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_0
    new-instance v1, Lcom/aio/downloader/utils/MyBase64$OutputStream;

    .line 1579
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x1

    .line 1578
    invoke-direct {v1, v3, v4}, Lcom/aio/downloader/utils/MyBase64$OutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1580
    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .local v1, "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :try_start_1
    invoke-virtual {v1, p0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->write([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1587
    :try_start_2
    invoke-virtual {v1}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1592
    :goto_0
    return-void

    .line 1582
    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_0
    move-exception v2

    .line 1583
    .local v2, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1585
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    .line 1587
    :goto_2
    :try_start_4
    invoke-virtual {v0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 1590
    :goto_3
    throw v3

    .line 1588
    :catch_1
    move-exception v4

    goto :goto_3

    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_2
    move-exception v3

    goto :goto_0

    .line 1585
    :catchall_1
    move-exception v3

    move-object v0, v1

    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    goto :goto_2

    .line 1582
    .end local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    :catch_3
    move-exception v2

    move-object v0, v1

    .end local v1    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    .restart local v0    # "bos":Lcom/aio/downloader/utils/MyBase64$OutputStream;
    goto :goto_1
.end method

.method private static final getAlphabet(I)[B
    .locals 2
    .param p0, "options"    # I

    .prologue
    .line 474
    and-int/lit8 v0, p0, 0x10

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 475
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_URL_SAFE_ALPHABET:[B

    .line 479
    :goto_0
    return-object v0

    .line 476
    :cond_0
    and-int/lit8 v0, p0, 0x20

    const/16 v1, 0x20

    if-ne v0, v1, :cond_1

    .line 477
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_ORDERED_ALPHABET:[B

    goto :goto_0

    .line 479
    :cond_1
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_STANDARD_ALPHABET:[B

    goto :goto_0
.end method

.method private static final getDecodabet(I)[B
    .locals 2
    .param p0, "options"    # I

    .prologue
    .line 490
    and-int/lit8 v0, p0, 0x10

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 491
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_URL_SAFE_DECODABET:[B

    .line 495
    :goto_0
    return-object v0

    .line 492
    :cond_0
    and-int/lit8 v0, p0, 0x20

    const/16 v1, 0x20

    if-ne v0, v1, :cond_1

    .line 493
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_ORDERED_DECODABET:[B

    goto :goto_0

    .line 495
    :cond_1
    sget-object v0, Lcom/aio/downloader/utils/MyBase64;->_STANDARD_DECODABET:[B

    goto :goto_0
.end method
