.class Lorg/simpleframework/xml/transform/PackageMatcher;
.super Ljava/lang/Object;
.source "PackageMatcher.java"

# interfaces
.implements Lorg/simpleframework/xml/transform/Matcher;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    return-void
.end method

.method private matchEnum(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 102
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    .line 104
    .local v0, "parent":Ljava/lang/Class;
    if-eqz v0, :cond_1

    .line 105
    invoke-virtual {v0}, Ljava/lang/Class;->isEnum()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 106
    new-instance v1, Lorg/simpleframework/xml/transform/EnumTransform;

    invoke-direct {v1, p1}, Lorg/simpleframework/xml/transform/EnumTransform;-><init>(Ljava/lang/Class;)V

    .line 112
    :goto_0
    return-object v1

    .line 108
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->isEnum()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 109
    new-instance v1, Lorg/simpleframework/xml/transform/EnumTransform;

    invoke-direct {v1, p1}, Lorg/simpleframework/xml/transform/EnumTransform;-><init>(Ljava/lang/Class;)V

    goto :goto_0

    .line 112
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private matchFile(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 247
    const-class v0, Ljava/io/File;

    if-ne p1, v0, :cond_0

    .line 248
    new-instance v0, Lorg/simpleframework/xml/transform/FileTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/FileTransform;-><init>()V

    .line 250
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private matchLanguage(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 127
    const-class v0, Ljava/lang/Boolean;

    if-ne p1, v0, :cond_0

    .line 128
    new-instance v0, Lorg/simpleframework/xml/transform/BooleanTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/BooleanTransform;-><init>()V

    .line 157
    :goto_0
    return-object v0

    .line 130
    :cond_0
    const-class v0, Ljava/lang/Integer;

    if-ne p1, v0, :cond_1

    .line 131
    new-instance v0, Lorg/simpleframework/xml/transform/IntegerTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/IntegerTransform;-><init>()V

    goto :goto_0

    .line 133
    :cond_1
    const-class v0, Ljava/lang/Long;

    if-ne p1, v0, :cond_2

    .line 134
    new-instance v0, Lorg/simpleframework/xml/transform/LongTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/LongTransform;-><init>()V

    goto :goto_0

    .line 136
    :cond_2
    const-class v0, Ljava/lang/Double;

    if-ne p1, v0, :cond_3

    .line 137
    new-instance v0, Lorg/simpleframework/xml/transform/DoubleTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/DoubleTransform;-><init>()V

    goto :goto_0

    .line 139
    :cond_3
    const-class v0, Ljava/lang/Float;

    if-ne p1, v0, :cond_4

    .line 140
    new-instance v0, Lorg/simpleframework/xml/transform/FloatTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/FloatTransform;-><init>()V

    goto :goto_0

    .line 142
    :cond_4
    const-class v0, Ljava/lang/Short;

    if-ne p1, v0, :cond_5

    .line 143
    new-instance v0, Lorg/simpleframework/xml/transform/ShortTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/ShortTransform;-><init>()V

    goto :goto_0

    .line 145
    :cond_5
    const-class v0, Ljava/lang/Byte;

    if-ne p1, v0, :cond_6

    .line 146
    new-instance v0, Lorg/simpleframework/xml/transform/ByteTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/ByteTransform;-><init>()V

    goto :goto_0

    .line 148
    :cond_6
    const-class v0, Ljava/lang/Character;

    if-ne p1, v0, :cond_7

    .line 149
    new-instance v0, Lorg/simpleframework/xml/transform/CharacterTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/CharacterTransform;-><init>()V

    goto :goto_0

    .line 151
    :cond_7
    const-class v0, Ljava/lang/String;

    if-ne p1, v0, :cond_8

    .line 152
    new-instance v0, Lorg/simpleframework/xml/transform/StringTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/StringTransform;-><init>()V

    goto :goto_0

    .line 154
    :cond_8
    const-class v0, Ljava/lang/Class;

    if-ne p1, v0, :cond_9

    .line 155
    new-instance v0, Lorg/simpleframework/xml/transform/ClassTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/ClassTransform;-><init>()V

    goto :goto_0

    .line 157
    :cond_9
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private matchMath(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 172
    const-class v0, Ljava/math/BigDecimal;

    if-ne p1, v0, :cond_0

    .line 173
    new-instance v0, Lorg/simpleframework/xml/transform/BigDecimalTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/BigDecimalTransform;-><init>()V

    .line 178
    :goto_0
    return-object v0

    .line 175
    :cond_0
    const-class v0, Ljava/math/BigInteger;

    if-ne p1, v0, :cond_1

    .line 176
    new-instance v0, Lorg/simpleframework/xml/transform/BigIntegerTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/BigIntegerTransform;-><init>()V

    goto :goto_0

    .line 178
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private matchSQL(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 223
    const-class v0, Ljava/sql/Time;

    if-ne p1, v0, :cond_0

    .line 224
    new-instance v0, Lorg/simpleframework/xml/transform/DateTransform;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/transform/DateTransform;-><init>(Ljava/lang/Class;)V

    .line 232
    :goto_0
    return-object v0

    .line 226
    :cond_0
    const-class v0, Ljava/sql/Date;

    if-ne p1, v0, :cond_1

    .line 227
    new-instance v0, Lorg/simpleframework/xml/transform/DateTransform;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/transform/DateTransform;-><init>(Ljava/lang/Class;)V

    goto :goto_0

    .line 229
    :cond_1
    const-class v0, Ljava/sql/Timestamp;

    if-ne p1, v0, :cond_2

    .line 230
    new-instance v0, Lorg/simpleframework/xml/transform/DateTransform;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/transform/DateTransform;-><init>(Ljava/lang/Class;)V

    goto :goto_0

    .line 232
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private matchURL(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 265
    const-class v0, Ljava/net/URL;

    if-ne p1, v0, :cond_0

    .line 266
    new-instance v0, Lorg/simpleframework/xml/transform/URLTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/URLTransform;-><init>()V

    .line 268
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private matchUtility(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 193
    const-class v0, Ljava/util/Date;

    if-ne p1, v0, :cond_0

    .line 194
    new-instance v0, Lorg/simpleframework/xml/transform/DateTransform;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/transform/DateTransform;-><init>(Ljava/lang/Class;)V

    .line 208
    :goto_0
    return-object v0

    .line 196
    :cond_0
    const-class v0, Ljava/util/Locale;

    if-ne p1, v0, :cond_1

    .line 197
    new-instance v0, Lorg/simpleframework/xml/transform/LocaleTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/LocaleTransform;-><init>()V

    goto :goto_0

    .line 199
    :cond_1
    const-class v0, Ljava/util/Currency;

    if-ne p1, v0, :cond_2

    .line 200
    new-instance v0, Lorg/simpleframework/xml/transform/CurrencyTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/CurrencyTransform;-><init>()V

    goto :goto_0

    .line 202
    :cond_2
    const-class v0, Ljava/util/GregorianCalendar;

    if-ne p1, v0, :cond_3

    .line 203
    new-instance v0, Lorg/simpleframework/xml/transform/GregorianCalendarTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/GregorianCalendarTransform;-><init>()V

    goto :goto_0

    .line 205
    :cond_3
    const-class v0, Ljava/util/TimeZone;

    if-ne p1, v0, :cond_4

    .line 206
    new-instance v0, Lorg/simpleframework/xml/transform/TimeZoneTransform;

    invoke-direct {v0}, Lorg/simpleframework/xml/transform/TimeZoneTransform;-><init>()V

    goto :goto_0

    .line 208
    :cond_4
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public match(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 69
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "name":Ljava/lang/String;
    const-string v1, "java.lang"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchLanguage(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    .line 89
    :goto_0
    return-object v1

    .line 74
    :cond_0
    const-string v1, "java.util"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 75
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchUtility(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0

    .line 77
    :cond_1
    const-string v1, "java.net"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 78
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchURL(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0

    .line 80
    :cond_2
    const-string v1, "java.io"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 81
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchFile(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0

    .line 83
    :cond_3
    const-string v1, "java.sql"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 84
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchSQL(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0

    .line 86
    :cond_4
    const-string v1, "java.math"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 87
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchMath(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0

    .line 89
    :cond_5
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/transform/PackageMatcher;->matchEnum(Ljava/lang/Class;)Lorg/simpleframework/xml/transform/Transform;

    move-result-object v1

    goto :goto_0
.end method
