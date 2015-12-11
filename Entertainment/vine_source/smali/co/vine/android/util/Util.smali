.class public Lco/vine/android/util/Util;
.super Ljava/lang/Object;
.source "Util.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/Util$1;,
        Lco/vine/android/util/Util$ProfileImageSize;,
        Lco/vine/android/util/Util$AddressBookContact;,
        Lco/vine/android/util/Util$ContentType;
    }
.end annotation


# static fields
.field public static final ALPHA_MASK:I = -0x1000000

.field public static final BROADCAST_PERMISSION:Ljava/lang/String; = "co.vine.android.BROADCAST"

.field public static final COLOR_CHANGED_INTENT_FILTER:Landroid/content/IntentFilter;

.field public static final CURSOR_INCREMENT:I = 0x14

.field private static final DATE_FORMAT_LOCK:[I

.field public static final DATE_TIME_RFC1123:Ljava/text/SimpleDateFormat;

.field public static final DAY_MILLIS:J = 0x5265c00L

.field public static final DECIMAL_FORMAT:Ljava/text/DecimalFormat;

.field public static final DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

.field public static final DEFAULT_PAGE_SIZE:I = 0xa

.field public static final FIELD_TYPE_FAX:Ljava/lang/String; = "fax"

.field public static final FIELD_TYPE_HOME:Ljava/lang/String; = "home"

.field public static final FIELD_TYPE_MAIN:Ljava/lang/String; = "main"

.field public static final FIELD_TYPE_MOBILE:Ljava/lang/String; = "mobile"

.field public static final FIELD_TYPE_OTHER:Ljava/lang/String; = "other"

.field public static final FIELD_TYPE_WORK:Ljava/lang/String; = "work"

.field public static final FILE:Ljava/lang/String; = "file"

.field public static final FILE_SCHEME:Ljava/lang/String; = "file://"

.field public static final GLOBAL_LIMIT:I = 0x190

.field public static final HALF_ALPHA_MASK:I = -0x80000000

.field public static final HOUR_MILLIS:J = 0x36ee80L

.field public static final HTTP_BAD_REQUEST:I = 0x190

.field public static final HTTP_NOT_FOUND:I = 0x194

.field public static final HTTP_OK:I = 0xc8

.field public static final HTTP_UNAUTHORIZED:I = 0x191

.field public static final IO_BUFFER_SIZE:I = 0x1000

.field public static final KB_BYTES:I = 0x400

.field public static final MARKER_COLON:C = ':'

.field public static final MARKER_QUOTES:C = '\"'

.field public static final MARKER_SEMI_COLON:C = ';'

.field public static final MAX_FOLLOW_REQUESTS:I = 0x5

.field public static final MB_BYTES:I = 0x100000

.field public static final MINUTE_MILLIS:J = 0xea60L

.field public static final MIN_PASSWORD_CHARS:I = 0x8

.field public static final MIN_USERNAME_CHARS:I = 0x3

.field public static final MONTH_MILLIS:J = 0x9ca41900L

.field private static final PATTERN_COMMENT:Ljava/util/regex/Pattern;

.field private static final PATTERN_POST:Ljava/util/regex/Pattern;

.field public static final PATTERN_USERNAME:Ljava/util/regex/Pattern;

.field public static final RTL_THRESHOLD:D = 0.3

.field public static final SECOND_MILLIS:J = 0x3e8L

.field public static final THIRTY_FIVE_ALPHA_MASK:I = 0x5a000000

.field public static final TIMESTAMP_FORMAT:Ljava/lang/String; = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

.field public static final TWENTY_ALPHA_MASK:I = 0x33000000

.field public static final TWENTY_FOUR_ALPHA_MASK:I = 0x3d000000

.field public static final WEEK_MILLIS:J = 0x240c8400L

.field public static final YEAR_MILLIS:J = 0x757b12c00L

.field private static final numbersAndLetters:[C

.field private static sDateFormatNoYear:Ljava/text/SimpleDateFormat;

.field private static sDateFormatWithYear:Ljava/text/SimpleDateFormat;

.field public static final sRandom:Ljava/security/SecureRandom;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 111
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    sput-object v0, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    .line 112
    new-instance v0, Ljava/text/DecimalFormatSymbols;

    invoke-direct {v0}, Ljava/text/DecimalFormatSymbols;-><init>()V

    sput-object v0, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    .line 137
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/Util;->DATE_FORMAT_LOCK:[I

    .line 196
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/util/Util;->COLOR_CHANGED_INTENT_FILTER:Landroid/content/IntentFilter;

    .line 199
    sget-object v0, Lco/vine/android/util/Util;->COLOR_CHANGED_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.profileColor"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 202
    const-string v0, "<:\\s*?user\\s*?\\|\\s*?.*?:>([\\w\\s-]*?)<:>"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/Util;->PATTERN_USERNAME:Ljava/util/regex/Pattern;

    .line 204
    const-string v0, "<:\\s*?post\\s*?\\|\\s*?.*?:>([\\w\\s]*?)<:>"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/Util;->PATTERN_POST:Ljava/util/regex/Pattern;

    .line 206
    const-string v0, "\"(.+?)\\\\?\""

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/Util;->PATTERN_COMMENT:Ljava/util/regex/Pattern;

    .line 211
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    sput-object v0, Lco/vine/android/util/Util;->sRandom:Ljava/security/SecureRandom;

    .line 219
    const-string v0, "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    sput-object v0, Lco/vine/android/util/Util;->numbersAndLetters:[C

    .line 223
    new-instance v0, Lco/vine/android/util/SynchronizedDateFormat;

    const-string v1, "EEE, dd MMM yyyy HH:mm:ss zzz"

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Lco/vine/android/util/SynchronizedDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lco/vine/android/util/Util;->DATE_TIME_RFC1123:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1030
    return-void
.end method

.method public static addDirectionalMarkers(Ljava/lang/CharSequence;)Ljava/lang/String;
    .locals 8
    .param p0, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 1432
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1433
    .local v1, "builder":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 1434
    .local v6, "prev":C
    const/4 v4, 0x1

    .line 1436
    .local v4, "isFirst":Z
    invoke-interface {p0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .local v0, "arr$":[C
    array-length v5, v0

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_3

    aget-char v2, v0, v3

    .line 1437
    .local v2, "c":C
    const/16 v7, 0x23

    if-ne v6, v7, :cond_0

    .line 1438
    invoke-static {v2}, Lco/vine/android/util/Util;->isRtlCharacter(C)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 1439
    const-string v7, "\u200f"

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1445
    :cond_0
    :goto_1
    if-eqz v4, :cond_2

    .line 1446
    const/4 v4, 0x0

    .line 1450
    :goto_2
    move v6, v2

    .line 1436
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1441
    :cond_1
    const-string v7, "\u200e"

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 1448
    :cond_2
    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1452
    .end local v2    # "c":C
    :cond_3
    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1454
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

.method public static adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V
    .locals 12
    .param p1, "contentSb"    # Landroid/text/Editable;
    .param p2, "offset"    # I
    .param p3, "xmlEntity"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;",
            "Landroid/text/Editable;",
            "IZ)V"
        }
    .end annotation

    .prologue
    .local p0, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const/16 v10, 0x200f

    const/16 v9, 0x200e

    const/4 v11, 0x1

    .line 1075
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v8

    if-ge v5, v8, :cond_6

    .line 1076
    invoke-interface {p1, v5}, Landroid/text/Editable;->charAt(I)C

    move-result v0

    .line 1077
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isHighSurrogate(C)Z

    move-result v8

    if-nez v8, :cond_0

    if-eq v0, v9, :cond_0

    if-ne v0, v10, :cond_5

    .line 1078
    :cond_0
    if-eq v0, v9, :cond_1

    if-ne v0, v10, :cond_4

    .line 1079
    :cond_1
    const/4 v1, 0x1

    .line 1084
    .local v1, "directionalityOffset":I
    :goto_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineEntity;

    .line 1085
    .local v4, "entity":Lco/vine/android/api/VineEntity;
    iget-boolean v8, v4, Lco/vine/android/api/VineEntity;->adjusted:Z

    if-nez v8, :cond_2

    .line 1088
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    add-int/2addr v8, p2

    add-int v7, v8, v1

    .line 1089
    .local v7, "startWithOffset":I
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    add-int v3, v8, p2

    .line 1090
    .local v3, "endWithOffset":I
    if-le v7, v5, :cond_2

    .line 1091
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    if-ge v7, v8, :cond_3

    .line 1092
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    add-int/lit8 v8, v8, 0x1

    iput v8, v4, Lco/vine/android/api/VineEntity;->start:I

    .line 1094
    :cond_3
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v8

    if-ge v3, v8, :cond_2

    .line 1095
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    add-int/lit8 v8, v8, 0x1

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    goto :goto_2

    .line 1081
    .end local v1    # "directionalityOffset":I
    .end local v3    # "endWithOffset":I
    .end local v4    # "entity":Lco/vine/android/api/VineEntity;
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v7    # "startWithOffset":I
    :cond_4
    const/4 v1, 0x0

    .restart local v1    # "directionalityOffset":I
    goto :goto_1

    .line 1075
    .end local v1    # "directionalityOffset":I
    :cond_5
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 1102
    .end local v0    # "c":C
    :cond_6
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .restart local v6    # "i$":Ljava/util/Iterator;
    :cond_7
    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_e

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineEntity;

    .line 1103
    .restart local v4    # "entity":Lco/vine/android/api/VineEntity;
    iget-boolean v8, v4, Lco/vine/android/api/VineEntity;->adjusted:Z

    if-nez v8, :cond_7

    .line 1106
    iget-object v8, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    if-nez v8, :cond_8

    .line 1108
    iput-boolean v11, v4, Lco/vine/android/api/VineEntity;->adjusted:Z

    goto :goto_3

    .line 1111
    :cond_8
    invoke-virtual {v4}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v8

    if-eqz v8, :cond_b

    .line 1112
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->start:I

    .line 1113
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    .line 1114
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v8

    if-eqz v8, :cond_a

    .line 1115
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->end:I

    iget-object v10, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-interface {p1, v8, v9, v10}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1123
    :goto_4
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->start:I

    sub-int/2addr v8, v9

    iget-object v9, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    sub-int/2addr v8, v9

    sub-int/2addr p2, v8

    .line 1124
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget-object v9, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int/2addr v8, v9

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    .line 1141
    :cond_9
    :goto_5
    iput-boolean v11, v4, Lco/vine/android/api/VineEntity;->adjusted:Z

    goto :goto_3

    .line 1118
    :cond_a
    :try_start_0
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->end:I

    iget-object v10, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-interface {p1, v8, v9, v10}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_4

    .line 1119
    :catch_0
    move-exception v2

    .line 1120
    .local v2, "e":Ljava/lang/IndexOutOfBoundsException;
    const-string v8, "Supressing IOOBE with replace"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v2, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4

    .line 1125
    .end local v2    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_b
    invoke-virtual {v4}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v8

    if-eqz v8, :cond_c

    .line 1126
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "#"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    .line 1127
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->start:I

    .line 1128
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    .line 1129
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->end:I

    iget-object v10, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-interface {p1, v8, v9, v10}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1130
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->start:I

    sub-int/2addr v8, v9

    sub-int/2addr p2, v8

    .line 1131
    iget-object v8, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    add-int/2addr p2, v8

    .line 1132
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget-object v9, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int/2addr v8, v9

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    goto :goto_5

    .line 1133
    :cond_c
    invoke-virtual {v4}, Lco/vine/android/api/VineEntity;->isUserListType()Z

    move-result v8

    if-nez v8, :cond_d

    invoke-virtual {v4}, Lco/vine/android/api/VineEntity;->isCommentListType()Z

    move-result v8

    if-eqz v8, :cond_9

    .line 1134
    :cond_d
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->start:I

    .line 1135
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    add-int/2addr v8, p2

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    .line 1136
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->end:I

    iget-object v10, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-interface {p1, v8, v9, v10}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1137
    iget v8, v4, Lco/vine/android/api/VineEntity;->end:I

    iget v9, v4, Lco/vine/android/api/VineEntity;->start:I

    sub-int/2addr v8, v9

    sub-int/2addr p2, v8

    .line 1138
    iget-object v8, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    add-int/2addr p2, v8

    .line 1139
    iget v8, v4, Lco/vine/android/api/VineEntity;->start:I

    iget-object v9, v4, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int/2addr v8, v9

    iput v8, v4, Lco/vine/android/api/VineEntity;->end:I

    goto/16 :goto_5

    .line 1143
    .end local v4    # "entity":Lco/vine/android/api/VineEntity;
    :cond_e
    return-void
.end method

.method public static changeProfileColor(Landroid/app/Activity;)V
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1498
    new-instance v0, Landroid/content/Intent;

    const-string v1, "co.vine.android.profileColor"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 1499
    return-void
.end method

.method public static cleanse(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "text"    # Ljava/lang/String;

    .prologue
    .line 1026
    const-string v0, "\n"

    const-string v1, " "

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static closeSilently(Ljava/io/Closeable;)V
    .locals 1
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 227
    if-eqz p0, :cond_0

    .line 229
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 230
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static deleteFileRecursively(Ljava/io/File;)V
    .locals 6
    .param p0, "file"    # Ljava/io/File;

    .prologue
    .line 1160
    if-eqz p0, :cond_1

    .line 1161
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1162
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 1163
    .local v2, "files":[Ljava/io/File;
    if-eqz v2, :cond_1

    .line 1164
    move-object v0, v2

    .local v0, "arr$":[Ljava/io/File;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 1165
    .local v1, "f":Ljava/io/File;
    invoke-static {v1}, Lco/vine/android/util/Util;->deleteFileRecursively(Ljava/io/File;)V

    .line 1164
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1169
    .end local v0    # "arr$":[Ljava/io/File;
    .end local v1    # "f":Ljava/io/File;
    .end local v2    # "files":[Ljava/io/File;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    .line 1172
    :cond_1
    return-void
.end method

.method public static forceCustomLocale(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1370
    invoke-static {p0}, Lco/vine/android/util/Util;->getCustomLocale(Landroid/content/Context;)Ljava/util/Locale;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->forceCustomLocale(Landroid/content/Context;Ljava/util/Locale;Z)V

    .line 1371
    return-void
.end method

.method public static forceCustomLocale(Landroid/content/Context;Ljava/util/Locale;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "locale"    # Ljava/util/Locale;
    .param p2, "updateResources"    # Z

    .prologue
    .line 1357
    if-eqz p1, :cond_0

    .line 1358
    invoke-static {p1}, Ljava/util/Locale;->setDefault(Ljava/util/Locale;)V

    .line 1359
    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/client/VineAPI;->refreshLocale()V

    .line 1360
    if-eqz p2, :cond_0

    .line 1361
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1362
    .local v1, "resources":Landroid/content/res/Resources;
    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 1363
    .local v0, "config":Landroid/content/res/Configuration;
    iput-object p1, v0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 1364
    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/res/Resources;->updateConfiguration(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V

    .line 1367
    .end local v0    # "config":Landroid/content/res/Configuration;
    .end local v1    # "resources":Landroid/content/res/Resources;
    :cond_0
    return-void
.end method

.method public static formatFileSize(Landroid/content/res/Resources;J)Ljava/lang/String;
    .locals 11
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "bytes"    # J

    .prologue
    const-wide/32 v9, 0xf4240

    const-wide/16 v7, 0x3e8

    const-wide/16 v4, 0x1

    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 1218
    sget-object v1, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    const v2, 0x7f0e015f

    invoke-virtual {p0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/text/DecimalFormatSymbols;->setGroupingSeparator(C)V

    .line 1220
    const/4 v0, 0x3

    .line 1222
    .local v0, "groupingSize":I
    const v1, 0x7f0e015a

    :try_start_0
    invoke-virtual {p0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1225
    :goto_0
    sget-object v1, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v1, v0}, Ljava/text/DecimalFormat;->setGroupingSize(I)V

    .line 1226
    sget-object v1, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v1, v3}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 1227
    sget-object v1, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    sget-object v2, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    invoke-virtual {v1, v2}, Ljava/text/DecimalFormat;->setDecimalFormatSymbols(Ljava/text/DecimalFormatSymbols;)V

    .line 1228
    const-wide/32 v1, 0x3b9aca00

    div-long v1, p1, v1

    cmp-long v1, v1, v4

    if-ltz v1, :cond_0

    .line 1229
    const v1, 0x7f0e0159

    new-array v2, v3, [Ljava/lang/Object;

    sget-object v3, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    const-wide/32 v4, 0x3b9aca00

    div-long v4, p1, v4

    invoke-virtual {v3, v4, v5}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1235
    :goto_1
    return-object v1

    .line 1230
    :cond_0
    div-long v1, p1, v9

    cmp-long v1, v1, v4

    if-ltz v1, :cond_1

    .line 1231
    const v1, 0x7f0e015c

    new-array v2, v3, [Ljava/lang/Object;

    sget-object v3, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    div-long v4, p1, v9

    invoke-virtual {v3, v4, v5}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1232
    :cond_1
    div-long v1, p1, v7

    cmp-long v1, v1, v4

    if-ltz v1, :cond_2

    .line 1233
    const v1, 0x7f0e015b

    new-array v2, v3, [Ljava/lang/Object;

    sget-object v3, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    div-long v4, p1, v7

    invoke-virtual {v3, v4, v5}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1235
    :cond_2
    const v1, 0x7f0e0157

    new-array v2, v3, [Ljava/lang/Object;

    sget-object v3, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v3, p1, p2}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1223
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static fromByteArray([B)Ljava/lang/Object;
    .locals 5
    .param p0, "bytes"    # [B

    .prologue
    const/4 v4, 0x0

    .line 905
    if-nez p0, :cond_0

    .line 919
    :goto_0
    return-object v4

    .line 908
    :cond_0
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 909
    .local v0, "bis":Ljava/io/ByteArrayInputStream;
    const/4 v2, 0x0

    .line 911
    .local v2, "ois":Ljava/io/ObjectInputStream;
    :try_start_0
    new-instance v3, Ljava/io/ObjectInputStream;

    invoke-direct {v3, v0}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 912
    .end local v2    # "ois":Ljava/io/ObjectInputStream;
    .local v3, "ois":Ljava/io/ObjectInputStream;
    :try_start_1
    invoke-virtual {v3}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v4

    .line 918
    invoke-static {v3}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 919
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .line 913
    .end local v3    # "ois":Ljava/io/ObjectInputStream;
    .restart local v2    # "ois":Ljava/io/ObjectInputStream;
    :catch_0
    move-exception v1

    .line 918
    .local v1, "e":Ljava/io/IOException;
    :goto_1
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 919
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .line 915
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 918
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    :goto_2
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 919
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .line 918
    .end local v1    # "e":Ljava/lang/ClassNotFoundException;
    :catchall_0
    move-exception v4

    :goto_3
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 919
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v4

    .line 918
    .end local v2    # "ois":Ljava/io/ObjectInputStream;
    .restart local v3    # "ois":Ljava/io/ObjectInputStream;
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "ois":Ljava/io/ObjectInputStream;
    .restart local v2    # "ois":Ljava/io/ObjectInputStream;
    goto :goto_3

    .line 915
    .end local v2    # "ois":Ljava/io/ObjectInputStream;
    .restart local v3    # "ois":Ljava/io/ObjectInputStream;
    :catch_2
    move-exception v1

    move-object v2, v3

    .end local v3    # "ois":Ljava/io/ObjectInputStream;
    .restart local v2    # "ois":Ljava/io/ObjectInputStream;
    goto :goto_2

    .line 913
    .end local v2    # "ois":Ljava/io/ObjectInputStream;
    .restart local v3    # "ois":Ljava/io/ObjectInputStream;
    :catch_3
    move-exception v1

    move-object v2, v3

    .end local v3    # "ois":Ljava/io/ObjectInputStream;
    .restart local v2    # "ois":Ljava/io/ObjectInputStream;
    goto :goto_1
.end method

.method public static getActiveNetworkType(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1532
    const-string v2, "connectivity"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 1534
    .local v1, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 1535
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    :goto_0
    return v2

    :cond_0
    const/4 v2, -0x1

    goto :goto_0
.end method

.method public static getAddressBookJson(Landroid/content/ContentResolver;)Ljava/lang/String;
    .locals 25
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 701
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 702
    .local v10, "contactsHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lco/vine/android/util/Util$AddressBookContact;>;"
    new-instance v18, Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-direct/range {v18 .. v18}, Lcom/fasterxml/jackson/core/JsonFactory;-><init>()V

    .line 703
    .local v18, "jf":Lcom/fasterxml/jackson/core/JsonFactory;
    new-instance v8, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v8}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 704
    .local v8, "ba":Ljava/io/ByteArrayOutputStream;
    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonGenerator(Ljava/io/OutputStream;)Lcom/fasterxml/jackson/core/JsonGenerator;

    move-result-object v19

    .line 706
    .local v19, "jg":Lcom/fasterxml/jackson/core/JsonGenerator;
    const/4 v2, 0x7

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "starred"

    aput-object v3, v4, v2

    const/4 v2, 0x1

    const-string v3, "times_contacted"

    aput-object v3, v4, v2

    const/4 v2, 0x2

    const-string v3, "display_name"

    aput-object v3, v4, v2

    const/4 v2, 0x3

    const-string v3, "display_name"

    aput-object v3, v4, v2

    const/4 v2, 0x4

    const-string v3, "display_name_alt"

    aput-object v3, v4, v2

    const/4 v2, 0x5

    const-string v3, "data1"

    aput-object v3, v4, v2

    const/4 v2, 0x6

    const-string v3, "data2"

    aput-object v3, v4, v2

    .line 716
    .local v4, "projection":[Ljava/lang/String;
    sget-object v3, Landroid/provider/ContactsContract$CommonDataKinds$Phone;->CONTENT_URI:Landroid/net/Uri;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-virtual/range {v2 .. v7}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 718
    .local v11, "cursor":Landroid/database/Cursor;
    if-eqz v11, :cond_9

    .line 719
    :cond_0
    :goto_0
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 720
    const/4 v2, 0x0

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-lez v2, :cond_6

    const/16 v23, 0x1

    .line 721
    .local v23, "starred":Z
    :goto_1
    const/4 v2, 0x1

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v24

    .line 722
    .local v24, "timesContacted":I
    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 723
    .local v21, "name":Ljava/lang/String;
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x3

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 724
    :cond_1
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v2, 0x4

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 725
    :cond_2
    const/4 v2, 0x5

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v22

    .line 726
    .local v22, "phone":Ljava/lang/String;
    const/4 v2, 0x6

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getPhoneLabelFromType(I)Ljava/lang/String;

    move-result-object v20

    .line 728
    .local v20, "label":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 729
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    move-object/from16 v21, v22

    .line 730
    :cond_3
    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/Util$AddressBookContact;

    move-object v9, v2

    .line 732
    .local v9, "contact":Lco/vine/android/util/Util$AddressBookContact;
    :goto_2
    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v9, v0, v1}, Lco/vine/android/util/Util$AddressBookContact;->addPhone(Ljava/lang/String;Ljava/lang/String;)V

    .line 733
    if-eqz v23, :cond_4

    invoke-virtual {v9}, Lco/vine/android/util/Util$AddressBookContact;->setStarred()V

    .line 734
    :cond_4
    if-lez v24, :cond_5

    move/from16 v0, v24

    invoke-virtual {v9, v0}, Lco/vine/android/util/Util$AddressBookContact;->setTimesContacted(I)V

    .line 735
    :cond_5
    move-object/from16 v0, v21

    invoke-virtual {v10, v0, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 720
    .end local v9    # "contact":Lco/vine/android/util/Util$AddressBookContact;
    .end local v20    # "label":Ljava/lang/String;
    .end local v21    # "name":Ljava/lang/String;
    .end local v22    # "phone":Ljava/lang/String;
    .end local v23    # "starred":Z
    .end local v24    # "timesContacted":I
    :cond_6
    const/16 v23, 0x0

    goto :goto_1

    .line 730
    .restart local v20    # "label":Ljava/lang/String;
    .restart local v21    # "name":Ljava/lang/String;
    .restart local v22    # "phone":Ljava/lang/String;
    .restart local v23    # "starred":Z
    .restart local v24    # "timesContacted":I
    :cond_7
    new-instance v9, Lco/vine/android/util/Util$AddressBookContact;

    move-object/from16 v0, v21

    invoke-direct {v9, v0}, Lco/vine/android/util/Util$AddressBookContact;-><init>(Ljava/lang/String;)V

    goto :goto_2

    .line 738
    .end local v20    # "label":Ljava/lang/String;
    .end local v21    # "name":Ljava/lang/String;
    .end local v22    # "phone":Ljava/lang/String;
    .end local v23    # "starred":Z
    .end local v24    # "timesContacted":I
    :cond_8
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 741
    :cond_9
    const/4 v2, 0x7

    new-array v4, v2, [Ljava/lang/String;

    .end local v4    # "projection":[Ljava/lang/String;
    const/4 v2, 0x0

    const-string v3, "starred"

    aput-object v3, v4, v2

    const/4 v2, 0x1

    const-string v3, "times_contacted"

    aput-object v3, v4, v2

    const/4 v2, 0x2

    const-string v3, "display_name"

    aput-object v3, v4, v2

    const/4 v2, 0x3

    const-string v3, "data4"

    aput-object v3, v4, v2

    const/4 v2, 0x4

    const-string v3, "display_name_alt"

    aput-object v3, v4, v2

    const/4 v2, 0x5

    const-string v3, "data1"

    aput-object v3, v4, v2

    const/4 v2, 0x6

    const-string v3, "data2"

    aput-object v3, v4, v2

    .line 751
    .restart local v4    # "projection":[Ljava/lang/String;
    sget-object v3, Landroid/provider/ContactsContract$CommonDataKinds$Email;->CONTENT_URI:Landroid/net/Uri;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-virtual/range {v2 .. v7}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 753
    if-eqz v11, :cond_13

    .line 754
    :cond_a
    :goto_3
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_12

    .line 755
    const/4 v2, 0x0

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-lez v2, :cond_10

    const/16 v23, 0x1

    .line 756
    .restart local v23    # "starred":Z
    :goto_4
    const/4 v2, 0x1

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v24

    .line 757
    .restart local v24    # "timesContacted":I
    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 758
    .restart local v21    # "name":Ljava/lang/String;
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_b

    const/4 v2, 0x3

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 759
    :cond_b
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_c

    const/4 v2, 0x4

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 760
    :cond_c
    const/4 v2, 0x5

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 761
    .local v12, "email":Ljava/lang/String;
    const/4 v2, 0x6

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getEmailLabelFromType(I)Ljava/lang/String;

    move-result-object v20

    .line 763
    .restart local v20    # "label":Ljava/lang/String;
    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_a

    .line 764
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_d

    move-object/from16 v21, v12

    .line 765
    :cond_d
    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/Util$AddressBookContact;

    move-object v9, v2

    .line 767
    .restart local v9    # "contact":Lco/vine/android/util/Util$AddressBookContact;
    :goto_5
    if-eqz v23, :cond_e

    invoke-virtual {v9}, Lco/vine/android/util/Util$AddressBookContact;->setStarred()V

    .line 768
    :cond_e
    if-lez v24, :cond_f

    move/from16 v0, v24

    invoke-virtual {v9, v0}, Lco/vine/android/util/Util$AddressBookContact;->setTimesContacted(I)V

    .line 769
    :cond_f
    move-object/from16 v0, v20

    invoke-virtual {v9, v0, v12}, Lco/vine/android/util/Util$AddressBookContact;->addEmail(Ljava/lang/String;Ljava/lang/String;)V

    .line 770
    move-object/from16 v0, v21

    invoke-virtual {v10, v0, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 755
    .end local v9    # "contact":Lco/vine/android/util/Util$AddressBookContact;
    .end local v12    # "email":Ljava/lang/String;
    .end local v20    # "label":Ljava/lang/String;
    .end local v21    # "name":Ljava/lang/String;
    .end local v23    # "starred":Z
    .end local v24    # "timesContacted":I
    :cond_10
    const/16 v23, 0x0

    goto :goto_4

    .line 765
    .restart local v12    # "email":Ljava/lang/String;
    .restart local v20    # "label":Ljava/lang/String;
    .restart local v21    # "name":Ljava/lang/String;
    .restart local v23    # "starred":Z
    .restart local v24    # "timesContacted":I
    :cond_11
    new-instance v9, Lco/vine/android/util/Util$AddressBookContact;

    move-object/from16 v0, v21

    invoke-direct {v9, v0}, Lco/vine/android/util/Util$AddressBookContact;-><init>(Ljava/lang/String;)V

    goto :goto_5

    .line 773
    .end local v12    # "email":Ljava/lang/String;
    .end local v20    # "label":Ljava/lang/String;
    .end local v21    # "name":Ljava/lang/String;
    .end local v23    # "starred":Z
    .end local v24    # "timesContacted":I
    :cond_12
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 776
    :cond_13
    invoke-virtual {v10}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1d

    .line 777
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 778
    invoke-virtual {v10}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_6
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1c

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/util/Util$AddressBookContact;

    .line 779
    .restart local v9    # "contact":Lco/vine/android/util/Util$AddressBookContact;
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 780
    const-string v2, "name"

    iget-object v3, v9, Lco/vine/android/util/Util$AddressBookContact;->name:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStringField(Ljava/lang/String;Ljava/lang/String;)V

    .line 781
    iget-boolean v2, v9, Lco/vine/android/util/Util$AddressBookContact;->starred:Z

    if-eqz v2, :cond_14

    .line 782
    const-string v2, "starred"

    const/4 v3, 0x1

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeBooleanField(Ljava/lang/String;Z)V

    .line 784
    :cond_14
    iget v2, v9, Lco/vine/android/util/Util$AddressBookContact;->timesContacted:I

    if-lez v2, :cond_15

    .line 785
    const-string v2, "timesContacted"

    iget v3, v9, Lco/vine/android/util/Util$AddressBookContact;->timesContacted:I

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumberField(Ljava/lang/String;I)V

    .line 787
    :cond_15
    iget-object v2, v9, Lco/vine/android/util/Util$AddressBookContact;->emails:Ljava/util/HashSet;

    if-eqz v2, :cond_18

    .line 788
    const-string v2, "emailAddresses"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    .line 789
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 790
    iget-object v2, v9, Lco/vine/android/util/Util$AddressBookContact;->emails:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_7
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_17

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/util/HashSet;

    .line 791
    .local v14, "fieldSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 792
    invoke-virtual {v14}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .local v17, "i$":Ljava/util/Iterator;
    :goto_8
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_16

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lorg/apache/http/message/BasicNameValuePair;

    .line 793
    .local v13, "field":Lorg/apache/http/message/BasicNameValuePair;
    invoke-virtual {v13}, Lorg/apache/http/message/BasicNameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13}, Lorg/apache/http/message/BasicNameValuePair;->getValue()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeObjectField(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_8

    .line 795
    .end local v13    # "field":Lorg/apache/http/message/BasicNameValuePair;
    :cond_16
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    goto :goto_7

    .line 797
    .end local v14    # "fieldSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v17    # "i$":Ljava/util/Iterator;
    :cond_17
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    .line 799
    :cond_18
    iget-object v2, v9, Lco/vine/android/util/Util$AddressBookContact;->phones:Ljava/util/HashSet;

    if-eqz v2, :cond_1b

    .line 800
    const-string v2, "phoneNumbers"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    .line 801
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 802
    iget-object v2, v9, Lco/vine/android/util/Util$AddressBookContact;->phones:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_9
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1a

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/util/HashSet;

    .line 803
    .restart local v14    # "fieldSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 804
    invoke-virtual {v14}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .restart local v17    # "i$":Ljava/util/Iterator;
    :goto_a
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lorg/apache/http/message/BasicNameValuePair;

    .line 805
    .restart local v13    # "field":Lorg/apache/http/message/BasicNameValuePair;
    invoke-virtual {v13}, Lorg/apache/http/message/BasicNameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13}, Lorg/apache/http/message/BasicNameValuePair;->getValue()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeObjectField(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_a

    .line 807
    .end local v13    # "field":Lorg/apache/http/message/BasicNameValuePair;
    :cond_19
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    goto :goto_9

    .line 809
    .end local v14    # "fieldSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v17    # "i$":Ljava/util/Iterator;
    :cond_1a
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    .line 811
    :cond_1b
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    goto/16 :goto_6

    .line 813
    .end local v9    # "contact":Lco/vine/android/util/Util$AddressBookContact;
    :cond_1c
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    .line 814
    invoke-virtual/range {v19 .. v19}, Lcom/fasterxml/jackson/core/JsonGenerator;->close()V

    .line 816
    :cond_1d
    invoke-virtual {v8}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getCacheDir(Landroid/content/Context;)Ljava/io/File;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 371
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 372
    .local v0, "externalCacheDir":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 375
    .end local v0    # "externalCacheDir":Ljava/io/File;
    :goto_0
    return-object v0

    .restart local v0    # "externalCacheDir":Ljava/io/File;
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    goto :goto_0
.end method

.method public static getCacheSize(Landroid/content/Context;)J
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineLoggingException;
        }
    .end annotation

    .prologue
    .line 1181
    const-wide/16 v3, 0x0

    .line 1182
    .local v3, "size":J
    :try_start_0
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 1184
    .local v0, "cacheDir":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 1185
    invoke-static {v0}, Lorg/apache/commons/io/FileUtils;->sizeOfDirectory(Ljava/io/File;)J

    move-result-wide v5

    add-long/2addr v3, v5

    .line 1188
    :cond_0
    if-eqz v0, :cond_1

    .line 1189
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalFilesDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 1192
    :cond_1
    invoke-static {v0}, Lorg/apache/commons/io/FileUtils;->sizeOfDirectory(Ljava/io/File;)J

    move-result-wide v5

    add-long/2addr v3, v5

    .line 1194
    const/4 v5, 0x1

    invoke-static {v5}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseName(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 1196
    .local v2, "f":Ljava/io/File;
    if-eqz v2, :cond_2

    .line 1197
    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v5

    add-long/2addr v3, v5

    .line 1200
    :cond_2
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    if-eqz v5, :cond_4

    .line 1209
    .end local v3    # "size":J
    :cond_3
    :goto_0
    return-wide v3

    .line 1206
    .restart local v3    # "size":J
    :cond_4
    const-wide/32 v5, 0x7a120

    cmp-long v5, v3, v5

    if-gtz v5, :cond_3

    .line 1209
    const-wide/16 v3, 0x0

    goto :goto_0

    .line 1212
    .end local v0    # "cacheDir":Ljava/io/File;
    .end local v2    # "f":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 1213
    .local v1, "e":Ljava/lang/Throwable;
    new-instance v5, Lco/vine/android/VineLoggingException;

    invoke-direct {v5, v1}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/Throwable;)V

    throw v5
.end method

.method public static getColorWithBlackPercentage(IF)I
    .locals 9
    .param p0, "color"    # I
    .param p1, "percentBlack"    # F

    .prologue
    .line 1515
    const/high16 v7, 0x3f800000    # 1.0f

    sub-float v4, v7, p1

    .line 1516
    .local v4, "inversePercent":F
    shr-int/lit8 v7, p0, 0x10

    and-int/lit16 v5, v7, 0xff

    .line 1517
    .local v5, "r":I
    shr-int/lit8 v7, p0, 0x8

    and-int/lit16 v2, v7, 0xff

    .line 1518
    .local v2, "g":I
    and-int/lit16 v0, p0, 0xff

    .line 1520
    .local v0, "b":I
    int-to-float v7, v5

    mul-float/2addr v7, v4

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v6

    .line 1521
    .local v6, "rFloat":I
    int-to-float v7, v2

    mul-float/2addr v7, v4

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v3

    .line 1522
    .local v3, "gFloat":I
    int-to-float v7, v0

    mul-float/2addr v7, v4

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 1524
    .local v1, "bFloat":I
    shl-int/lit8 v7, v6, 0x10

    const/high16 v8, 0xff0000

    and-int v5, v7, v8

    .line 1525
    shl-int/lit8 v7, v3, 0x8

    const v8, 0xff00

    and-int v2, v7, v8

    .line 1526
    and-int/lit16 v0, v1, 0xff

    .line 1528
    const/high16 v7, -0x1000000

    or-int/2addr v7, v5

    or-int/2addr v7, v2

    or-int/2addr v7, v0

    return v7
.end method

.method public static getCountryCode()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1489
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1490
    .local v0, "locale":Ljava/util/Locale;
    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getCustomLocale(Landroid/content/Context;)Ljava/util/Locale;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x0

    .line 1337
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 1338
    .local v3, "prefs":Landroid/content/SharedPreferences;
    const-string v5, "pref_custom_locale_enabled"

    const/4 v6, 0x0

    invoke-interface {v3, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1339
    const-string v5, "pref_custom_locale"

    invoke-interface {v3, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1340
    .local v2, "localeCode":Ljava/lang/String;
    const-string v5, "pref_custom_locale_country"

    invoke-interface {v3, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1341
    .local v0, "countryCode":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1343
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 1344
    new-instance v1, Ljava/util/Locale;

    invoke-direct {v1, v2, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1348
    .local v1, "locale":Ljava/util/Locale;
    :goto_0
    invoke-virtual {v1}, Ljava/util/Locale;->getISO3Language()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1353
    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v1    # "locale":Ljava/util/Locale;
    .end local v2    # "localeCode":Ljava/lang/String;
    :goto_1
    return-object v1

    .line 1346
    .restart local v0    # "countryCode":Ljava/lang/String;
    .restart local v2    # "localeCode":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/util/Locale;

    invoke-direct {v1, v2}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    .restart local v1    # "locale":Ljava/util/Locale;
    goto :goto_0

    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v1    # "locale":Ljava/util/Locale;
    .end local v2    # "localeCode":Ljava/lang/String;
    :cond_1
    move-object v1, v4

    .line 1353
    goto :goto_1
.end method

.method public static getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1284
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_preferences"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method private static getEmailLabelFromType(I)Ljava/lang/String;
    .locals 1
    .param p0, "type"    # I

    .prologue
    .line 820
    packed-switch p0, :pswitch_data_0

    .line 828
    const-string v0, "other"

    :goto_0
    return-object v0

    .line 822
    :pswitch_0
    const-string v0, "home"

    goto :goto_0

    .line 825
    :pswitch_1
    const-string v0, "work"

    goto :goto_0

    .line 820
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static getEmailMessage(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1309
    invoke-static {}, Lco/vine/android/util/BuildUtil;->getMarket()I

    .line 1312
    const v0, 0x7f0e00e5

    invoke-static {p0, v0}, Lco/vine/android/util/Util;->getShareMyProfileMessage(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;
    .locals 2
    .param p0, "c"    # Landroid/content/Context;

    .prologue
    .line 381
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 383
    :goto_0
    return-object v1

    .line 382
    :catch_0
    move-exception v0

    .line 383
    .local v0, "e":Ljava/lang/Throwable;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getExternalFilesDir(Landroid/content/Context;)Ljava/io/File;
    .locals 2
    .param p0, "c"    # Landroid/content/Context;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x8
    .end annotation

    .prologue
    .line 445
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x7

    if-le v0, v1, :cond_0

    .line 446
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 448
    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    goto :goto_0
.end method

.method public static getFileSize(Landroid/content/Context;Landroid/net/Uri;)F
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 460
    const/4 v1, 0x0

    .line 462
    .local v1, "is":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 463
    invoke-virtual {v1}, Ljava/io/InputStream;->available()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    int-to-float v2, v2

    const/high16 v3, 0x44800000    # 1024.0f

    div-float/2addr v2, v3

    .line 467
    invoke-static {v1}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    :goto_0
    return v2

    .line 464
    :catch_0
    move-exception v0

    .line 465
    .local v0, "e":Ljava/io/IOException;
    const/4 v2, 0x0

    .line 467
    invoke-static {v1}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    invoke-static {v1}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v2
.end method

.method public static getFilesDir(Landroid/content/Context;)Ljava/io/File;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 435
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalFilesDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 436
    .local v0, "f":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 439
    .end local v0    # "f":Ljava/io/File;
    :goto_0
    return-object v0

    .restart local v0    # "f":Ljava/io/File;
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    goto :goto_0
.end method

.method public static getLocale()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1477
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1478
    .local v0, "current":Ljava/util/Locale;
    sget-object v1, Ljava/util/Locale;->TRADITIONAL_CHINESE:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Ljava/util/Locale;->TRADITIONAL_CHINESE:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    sget-object v1, Ljava/util/Locale;->SIMPLIFIED_CHINESE:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Ljava/util/Locale;->SIMPLIFIED_CHINESE:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1482
    :cond_1
    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1484
    :goto_0
    return-object v1

    :cond_2
    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getNextCursorSize(I)I
    .locals 1
    .param p0, "currentSize"    # I

    .prologue
    .line 1272
    add-int/lit8 v0, p0, 0x14

    return v0
.end method

.method private static getPhoneLabelFromType(I)Ljava/lang/String;
    .locals 1
    .param p0, "type"    # I

    .prologue
    .line 834
    packed-switch p0, :pswitch_data_0

    .line 853
    :pswitch_0
    const-string v0, "other"

    :goto_0
    return-object v0

    .line 836
    :pswitch_1
    const-string v0, "home"

    goto :goto_0

    .line 839
    :pswitch_2
    const-string v0, "work"

    goto :goto_0

    .line 842
    :pswitch_3
    const-string v0, "mobile"

    goto :goto_0

    .line 845
    :pswitch_4
    const-string v0, "main"

    goto :goto_0

    .line 850
    :pswitch_5
    const-string v0, "fax"

    goto :goto_0

    .line 834
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_5
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public static getProfileColor(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1502
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "profile_background"

    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static getRecentActivityData(Landroid/app/Activity;)Ljava/lang/String;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1494
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "pref_saved_state_data"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;
    .locals 26
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "timestamp"    # J
    .param p3, "verbose"    # Z

    .prologue
    .line 581
    sget-object v22, Lco/vine/android/util/Util;->DATE_FORMAT_LOCK:[I

    monitor-enter v22

    .line 582
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    .line 583
    .local v18, "res":Landroid/content/res/Resources;
    sget-object v21, Lco/vine/android/util/Util;->sDateFormatWithYear:Ljava/text/SimpleDateFormat;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v21, :cond_0

    .line 584
    const/16 v17, 0x0

    .line 586
    .local v17, "order":[C
    :try_start_1
    invoke-static/range {p0 .. p0}, Landroid/text/format/DateFormat;->getDateFormatOrder(Landroid/content/Context;)[C
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v17

    .line 590
    :goto_0
    if-nez v17, :cond_1

    .line 591
    :try_start_2
    new-instance v21, Ljava/text/SimpleDateFormat;

    const v23, 0x7f0e00aa

    move-object/from16 v0, v18

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v21, Lco/vine/android/util/Util;->sDateFormatNoYear:Ljava/text/SimpleDateFormat;

    .line 592
    new-instance v21, Ljava/text/SimpleDateFormat;

    const v23, 0x7f0e00a9

    move-object/from16 v0, v18

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v21, Lco/vine/android/util/Util;->sDateFormatWithYear:Ljava/text/SimpleDateFormat;

    .line 631
    .end local v17    # "order":[C
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v23

    sub-long v8, v23, p1

    .line 632
    .local v8, "diff":J
    const-wide/16 v23, 0x0

    cmp-long v21, v8, v23

    if-ltz v21, :cond_c

    .line 633
    const-wide/32 v23, 0xea60

    cmp-long v21, v8, v23

    if-gez v21, :cond_4

    .line 634
    const-wide/16 v23, 0x3e8

    div-long v23, v8, v23

    move-wide/from16 v0, v23

    long-to-int v0, v0

    move/from16 v19, v0

    .line 635
    .local v19, "secs":I
    if-eqz p3, :cond_3

    const v21, 0x7f0d0013

    :goto_1
    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    move-object/from16 v0, v18

    move/from16 v1, v21

    move/from16 v2, v19

    move-object/from16 v3, v23

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    .line 665
    .end local v19    # "secs":I
    :goto_2
    return-object v21

    .line 594
    .end local v8    # "diff":J
    .restart local v17    # "order":[C
    :cond_1
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    .line 595
    .local v15, "noYear":Ljava/lang/StringBuilder;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    .line 596
    .local v20, "withYear":Ljava/lang/StringBuilder;
    const/4 v11, 0x0

    .line 597
    .local v11, "i":I
    move-object/from16 v4, v17

    .local v4, "arr$":[C
    array-length v13, v4

    .local v13, "len$":I
    const/4 v12, 0x0

    .local v12, "i$":I
    :goto_3
    if-ge v12, v13, :cond_0

    aget-char v5, v4, v12

    .line 598
    .local v5, "c":C
    sparse-switch v5, :sswitch_data_0

    .line 625
    :cond_2
    :goto_4
    add-int/lit8 v11, v11, 0x1

    .line 626
    new-instance v21, Ljava/text/SimpleDateFormat;

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v21, Lco/vine/android/util/Util;->sDateFormatNoYear:Ljava/text/SimpleDateFormat;

    .line 627
    new-instance v21, Ljava/text/SimpleDateFormat;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v21, Lco/vine/android/util/Util;->sDateFormatWithYear:Ljava/text/SimpleDateFormat;

    .line 597
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 600
    :sswitch_0
    invoke-virtual {v15, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 601
    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 602
    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v21, v0

    move/from16 v0, v21

    if-eq v11, v0, :cond_2

    .line 603
    const/16 v21, 0x20

    move/from16 v0, v21

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 604
    const/16 v21, 0x20

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 666
    .end local v4    # "arr$":[C
    .end local v5    # "c":C
    .end local v11    # "i":I
    .end local v12    # "i$":I
    .end local v13    # "len$":I
    .end local v15    # "noYear":Ljava/lang/StringBuilder;
    .end local v17    # "order":[C
    .end local v18    # "res":Landroid/content/res/Resources;
    .end local v20    # "withYear":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v21

    monitor-exit v22
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v21

    .line 609
    .restart local v4    # "arr$":[C
    .restart local v5    # "c":C
    .restart local v11    # "i":I
    .restart local v12    # "i$":I
    .restart local v13    # "len$":I
    .restart local v15    # "noYear":Ljava/lang/StringBuilder;
    .restart local v17    # "order":[C
    .restart local v18    # "res":Landroid/content/res/Resources;
    .restart local v20    # "withYear":Ljava/lang/StringBuilder;
    :sswitch_1
    :try_start_3
    invoke-virtual {v15, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 610
    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 611
    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v21, v0

    move/from16 v0, v21

    if-eq v11, v0, :cond_2

    .line 612
    const/16 v21, 0x20

    move/from16 v0, v21

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 613
    const/16 v21, 0x20

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 618
    :sswitch_2
    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 619
    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v21, v0

    move/from16 v0, v21

    if-eq v11, v0, :cond_2

    .line 620
    const/16 v21, 0x20

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 635
    .end local v4    # "arr$":[C
    .end local v5    # "c":C
    .end local v11    # "i":I
    .end local v12    # "i$":I
    .end local v13    # "len$":I
    .end local v15    # "noYear":Ljava/lang/StringBuilder;
    .end local v17    # "order":[C
    .end local v20    # "withYear":Ljava/lang/StringBuilder;
    .restart local v8    # "diff":J
    .restart local v19    # "secs":I
    :cond_3
    const v21, 0x7f0d0011

    goto/16 :goto_1

    .line 637
    .end local v19    # "secs":I
    :cond_4
    const-wide/32 v23, 0x36ee80

    cmp-long v21, v8, v23

    if-gez v21, :cond_6

    .line 638
    const-wide/32 v23, 0xea60

    div-long v23, v8, v23

    move-wide/from16 v0, v23

    long-to-int v14, v0

    .line 639
    .local v14, "mins":I
    if-eqz p3, :cond_5

    const v21, 0x7f0d000f

    :goto_5
    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    move-object/from16 v0, v18

    move/from16 v1, v21

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v14, v2}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    goto/16 :goto_2

    :cond_5
    const v21, 0x7f0d000d

    goto :goto_5

    .line 641
    .end local v14    # "mins":I
    :cond_6
    const-wide/32 v23, 0x5265c00

    cmp-long v21, v8, v23

    if-gez v21, :cond_8

    .line 642
    const-wide/32 v23, 0x36ee80

    div-long v23, v8, v23

    move-wide/from16 v0, v23

    long-to-int v10, v0

    .line 643
    .local v10, "hours":I
    if-eqz p3, :cond_7

    const v21, 0x7f0d000c

    :goto_6
    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    move-object/from16 v0, v18

    move/from16 v1, v21

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v10, v2}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    goto/16 :goto_2

    :cond_7
    const v21, 0x7f0d000a

    goto :goto_6

    .line 645
    .end local v10    # "hours":I
    :cond_8
    const-wide/32 v23, 0x240c8400

    cmp-long v21, v8, v23

    if-gez v21, :cond_a

    .line 646
    const-wide/32 v23, 0x5265c00

    div-long v23, v8, v23

    move-wide/from16 v0, v23

    long-to-int v7, v0

    .line 647
    .local v7, "days":I
    if-eqz p3, :cond_9

    const v21, 0x7f0d0009

    :goto_7
    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    move-object/from16 v0, v18

    move/from16 v1, v21

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v7, v2}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    goto/16 :goto_2

    :cond_9
    const v21, 0x7f0d0007

    goto :goto_7

    .line 651
    .end local v7    # "days":I
    :cond_a
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v16

    .line 653
    .local v16, "now":Ljava/util/Calendar;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v5

    .line 654
    .local v5, "c":Ljava/util/Calendar;
    new-instance v6, Ljava/util/Date;

    move-wide/from16 v0, p1

    invoke-direct {v6, v0, v1}, Ljava/util/Date;-><init>(J)V

    .line 655
    .local v6, "d":Ljava/util/Date;
    invoke-virtual {v5, v6}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 657
    const/16 v21, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v21

    const/16 v23, 0x1

    move/from16 v0, v23

    invoke-virtual {v5, v0}, Ljava/util/Calendar;->get(I)I

    move-result v23

    move/from16 v0, v21

    move/from16 v1, v23

    if-ne v0, v1, :cond_b

    .line 658
    sget-object v21, Lco/vine/android/util/Util;->sDateFormatNoYear:Ljava/text/SimpleDateFormat;

    move-object/from16 v0, v21

    invoke-virtual {v0, v6}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    goto/16 :goto_2

    .line 660
    :cond_b
    sget-object v21, Lco/vine/android/util/Util;->sDateFormatWithYear:Ljava/text/SimpleDateFormat;

    move-object/from16 v0, v21

    invoke-virtual {v0, v6}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22

    goto/16 :goto_2

    .line 665
    .end local v5    # "c":Ljava/util/Calendar;
    .end local v6    # "d":Ljava/util/Date;
    .end local v16    # "now":Ljava/util/Calendar;
    :cond_c
    sget-object v21, Lco/vine/android/util/Util;->sDateFormatWithYear:Ljava/text/SimpleDateFormat;

    new-instance v23, Ljava/util/Date;

    move-object/from16 v0, v23

    move-wide/from16 v1, p1

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v21

    monitor-exit v22
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 587
    .end local v8    # "diff":J
    .restart local v17    # "order":[C
    :catch_0
    move-exception v21

    goto/16 :goto_0

    .line 598
    nop

    :sswitch_data_0
    .sparse-switch
        0x4d -> :sswitch_1
        0x64 -> :sswitch_0
        0x79 -> :sswitch_2
    .end sparse-switch
.end method

.method private static getShareMyProfileMessage(Landroid/content/Context;I)Ljava/lang/String;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "stringId"    # I

    .prologue
    .line 1318
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-virtual {p0, p1, v0}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "vine://user"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lco/vine/android/util/BuildUtil;->getWebsiteUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/u"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getShareProfileMessage(Landroid/content/Context;Ljava/lang/String;J)Ljava/lang/String;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "userId"    # J

    .prologue
    .line 1323
    invoke-static {}, Lco/vine/android/util/BuildUtil;->getMarket()I

    .line 1326
    const v0, 0x7f0e020d

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "vine://user"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lco/vine/android/util/BuildUtil;->getWebsiteUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/u"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSharedPrefs(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 1295
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_preferences_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public static getSmsMessage(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1300
    invoke-static {}, Lco/vine/android/util/BuildUtil;->getMarket()I

    .line 1303
    const v0, 0x7f0e00e7

    invoke-static {p0, v0}, Lco/vine/android/util/Util;->getShareMyProfileMessage(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;
    .locals 12
    .param p0, "span"    # [Ljava/lang/Object;
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "marker"    # C

    .prologue
    const/4 v11, -0x1

    .line 270
    invoke-virtual {p1, p2}, Ljava/lang/String;->indexOf(I)I

    move-result v6

    .line 271
    .local v6, "start":I
    if-ne v6, v11, :cond_0

    .line 272
    new-instance v5, Landroid/text/SpannableString;

    invoke-direct {v5, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 311
    :goto_0
    return-object v5

    .line 274
    :cond_0
    add-int/lit8 v7, v6, 0x1

    invoke-virtual {p1, p2, v7}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 275
    .local v0, "end":I
    if-ne v0, v11, :cond_1

    .line 276
    new-instance v5, Landroid/text/SpannableString;

    invoke-direct {v5, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 279
    :cond_1
    array-length v1, p0

    .line 280
    .local v1, "maxSpans":I
    const/4 v4, 0x0

    .line 281
    .local v4, "spanIndex":I
    const/4 v2, 0x0

    .line 282
    .local v2, "next":I
    const/4 v3, 0x0

    .line 283
    .local v3, "offset":I
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 286
    .local v5, "ssb":Landroid/text/SpannableStringBuilder;
    :cond_2
    invoke-virtual {p1, v2, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 289
    add-int/lit8 v7, v6, 0x1

    invoke-virtual {p1, v7, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 291
    aget-object v7, p0, v4

    sub-int v8, v6, v3

    sub-int v9, v0, v3

    add-int/lit8 v9, v9, -0x1

    const/16 v10, 0x21

    invoke-static {v5, v7, v8, v9, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 294
    add-int/lit8 v4, v4, 0x1

    .line 295
    add-int/lit8 v2, v0, 0x1

    .line 296
    if-lt v4, v1, :cond_4

    .line 309
    :cond_3
    :goto_1
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0

    .line 300
    :cond_4
    invoke-virtual {p1, p2, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v6

    .line 301
    if-eq v6, v11, :cond_5

    .line 302
    add-int/lit8 v7, v6, 0x1

    invoke-virtual {p1, p2, v7}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 304
    add-int/lit8 v3, v3, 0x2

    .line 306
    :cond_5
    if-eq v6, v11, :cond_3

    if-ne v0, v11, :cond_2

    goto :goto_1
.end method

.method public static getTempFile(Landroid/content/Context;)Ljava/io/File;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 360
    const/4 v0, 0x6

    invoke-static {p0, v0}, Lco/vine/android/util/Util;->getTempFile(Landroid/content/Context;I)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public static getTempFile(Landroid/content/Context;I)Ljava/io/File;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fileNameSize"    # I

    .prologue
    .line 339
    invoke-static {p0}, Lco/vine/android/util/Util;->getCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 340
    .local v0, "cacheDir":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 341
    new-instance v1, Ljava/io/File;

    invoke-static {p1}, Lco/vine/android/util/Util;->randomString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 343
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getUriFromResouce(Landroid/content/Context;I)Landroid/net/Uri;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # I

    .prologue
    .line 348
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android.resource://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "body"    # Ljava/lang/String;

    .prologue
    .line 690
    sget-object v1, Lco/vine/android/util/Util;->PATTERN_USERNAME:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 691
    .local v0, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 692
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 694
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getVersionName(Landroid/content/Context;)Ljava/lang/String;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 1020
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 1021
    .local v1, "packageName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 1022
    .local v0, "pInfo":Landroid/content/pm/PackageInfo;
    iget-object v2, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    return-object v2
.end method

.method public static isCapableOfInline(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 416
    invoke-static {p0, v0}, Lco/vine/android/util/SystemUtil;->getMemoryRatio(Landroid/content/Context;Z)D

    move-result-wide v1

    const-wide v3, 0x3ff3333333333333L    # 1.2

    cmpl-double v1, v1, v3

    if-lez v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isCapableOfRecording(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 412
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasCamera()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->recordingEnabled:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isDefaultAvatarUrl(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 487
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "default.png"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEmojiOrSymbol(C)Z
    .locals 2
    .param p0, "c"    # C

    .prologue
    .line 1413
    invoke-static {p0}, Ljava/lang/Character$UnicodeBlock;->of(C)Ljava/lang/Character$UnicodeBlock;

    move-result-object v0

    .line 1414
    .local v0, "block":Ljava/lang/Character$UnicodeBlock;
    sget-object v1, Ljava/lang/Character$UnicodeBlock;->DINGBATS:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->SUPPLEMENTAL_ARROWS_A:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->BRAILLE_PATTERNS:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->SUPPLEMENTAL_ARROWS_B:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->SUPPLEMENTAL_MATHEMATICAL_OPERATORS:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->MISCELLANEOUS_SYMBOLS_AND_ARROWS:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->PRIVATE_USE_AREA:Ljava/lang/Character$UnicodeBlock;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isHighRes(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1539
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    const/16 v1, 0xf0

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isIntentAvailable(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 322
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 323
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 324
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v3, 0x10000

    invoke-virtual {v2, v0, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 326
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static isPopularTimeline(I)Z
    .locals 1
    .param p0, "groupType"    # I

    .prologue
    .line 1265
    const/4 v0, 0x5

    if-eq p0, v0, :cond_0

    const/16 v0, 0x8

    if-eq p0, v0, :cond_0

    const/4 v0, 0x4

    if-eq p0, v0, :cond_0

    const/16 v0, 0xb

    if-ne p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isRtlCharacter(C)Z
    .locals 2
    .param p0, "c"    # C

    .prologue
    .line 1405
    invoke-static {p0}, Ljava/lang/Character$UnicodeBlock;->of(C)Ljava/lang/Character$UnicodeBlock;

    move-result-object v0

    .line 1406
    .local v0, "block":Ljava/lang/Character$UnicodeBlock;
    sget-object v1, Ljava/lang/Character$UnicodeBlock;->ARABIC:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->ARABIC_PRESENTATION_FORMS_A:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->ARABIC_PRESENTATION_FORMS_B:Ljava/lang/Character$UnicodeBlock;

    if-eq v0, v1, :cond_0

    sget-object v1, Ljava/lang/Character$UnicodeBlock;->HEBREW:Ljava/lang/Character$UnicodeBlock;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isRtlLanguage(Ljava/lang/String;)Z
    .locals 11
    .param p0, "text"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    const/high16 v9, 0x3f800000    # 1.0f

    .line 1379
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    if-gtz v7, :cond_1

    .line 1398
    :cond_0
    :goto_0
    return v6

    .line 1383
    :cond_1
    const/4 v5, 0x0

    .local v5, "totalCount":F
    const/4 v4, 0x0

    .line 1384
    .local v4, "rtlCount":F
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .local v0, "arr$":[C
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_5

    aget-char v1, v0, v2

    .line 1385
    .local v1, "c":C
    invoke-static {v1}, Ljava/lang/Character$UnicodeBlock;->of(C)Ljava/lang/Character$UnicodeBlock;

    move-result-object v7

    sget-object v8, Ljava/lang/Character$UnicodeBlock;->GENERAL_PUNCTUATION:Ljava/lang/Character$UnicodeBlock;

    if-ne v7, v8, :cond_3

    .line 1384
    :cond_2
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 1389
    :cond_3
    invoke-static {v1}, Lco/vine/android/util/Util;->isRtlCharacter(C)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 1390
    add-float/2addr v4, v9

    .line 1392
    :cond_4
    invoke-static {v1}, Lco/vine/android/util/Util;->isEmojiOrSymbol(C)Z

    move-result v7

    if-nez v7, :cond_2

    .line 1393
    add-float/2addr v5, v9

    goto :goto_2

    .line 1398
    .end local v1    # "c":C
    :cond_5
    div-float v7, v4, v5

    float-to-double v7, v7

    const-wide v9, 0x3fd3333333333333L    # 0.3

    cmpl-double v7, v7, v9

    if-lez v7, :cond_0

    const/4 v6, 0x1

    goto :goto_0
.end method

.method public static isUrlLocal(Ljava/lang/String;)Z
    .locals 4
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 142
    if-nez p0, :cond_0

    .line 150
    :goto_0
    return v2

    .line 146
    :cond_0
    :try_start_0
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "scheme":Ljava/lang/String;
    const-string v3, "file"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 148
    .end local v1    # "scheme":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 150
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public static isUsEnglishLocale()Z
    .locals 2

    .prologue
    .line 1374
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v0

    .line 1375
    .local v0, "code":Ljava/lang/String;
    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method

.method public static isXauth2FactorError(Ltwitter4j/TwitterException;)Z
    .locals 2
    .param p0, "e"    # Ltwitter4j/TwitterException;

    .prologue
    .line 1332
    invoke-virtual {p0}, Ltwitter4j/TwitterException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 1333
    .local v0, "message":Ljava/lang/String;
    const-string v1, "231"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "User must verify login"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static md5Digest(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 555
    :try_start_0
    const-string v9, "MD5"

    invoke-static {v9}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v8

    .line 556
    .local v8, "messageDigest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v7

    .line 557
    .local v7, "md5bytes":[B
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 558
    .local v2, "hexString":Ljava/lang/StringBuilder;
    move-object v0, v7

    .local v0, "arr$":[B
    array-length v5, v0

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_1

    aget-byte v6, v0, v3

    .line 559
    .local v6, "md5byte":B
    and-int/lit16 v9, v6, 0xff

    invoke-static {v9}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    .line 560
    .local v1, "hex":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v9

    const/4 v10, 0x2

    if-ge v9, v10, :cond_0

    .line 561
    const/16 v9, 0x30

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 558
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 563
    :cond_0
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 567
    .end local v0    # "arr$":[B
    .end local v1    # "hex":Ljava/lang/String;
    .end local v2    # "hexString":Ljava/lang/StringBuilder;
    .end local v3    # "i$":I
    .end local v5    # "len$":I
    .end local v6    # "md5byte":B
    .end local v7    # "md5bytes":[B
    .end local v8    # "messageDigest":Ljava/security/MessageDigest;
    :catch_0
    move-exception v4

    .line 568
    .local v4, "ignore":Ljava/security/NoSuchAlgorithmException;
    const/4 v9, 0x0

    .end local v4    # "ignore":Ljava/security/NoSuchAlgorithmException;
    :goto_2
    return-object v9

    .line 566
    .restart local v0    # "arr$":[B
    .restart local v2    # "hexString":Ljava/lang/StringBuilder;
    .restart local v3    # "i$":I
    .restart local v5    # "len$":I
    .restart local v7    # "md5bytes":[B
    .restart local v8    # "messageDigest":Ljava/security/MessageDigest;
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    goto :goto_2
.end method

.method public static numberFormat(Landroid/content/res/Resources;J)Ljava/lang/String;
    .locals 1
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "number"    # J

    .prologue
    .line 993
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;JZ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static numberFormat(Landroid/content/res/Resources;JZ)Ljava/lang/String;
    .locals 13
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "number"    # J
    .param p3, "shorten"    # Z

    .prologue
    .line 937
    const v5, 0x7f0e0160

    invoke-virtual {p0, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    const/4 v6, 0x4

    if-ne v5, v6, :cond_1

    const/4 v4, 0x1

    .line 940
    .local v4, "tenThousands":Z
    :goto_0
    const v5, 0x7f0e015d

    invoke-virtual {p0, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    const/16 v6, 0x8

    if-ne v5, v6, :cond_2

    const/4 v1, 0x1

    .line 942
    .local v1, "hundredMillions":Z
    :goto_1
    const/4 v0, 0x3

    .line 944
    .local v0, "groupingSeperatorSize":I
    const v5, 0x7f0e015a

    :try_start_0
    invoke-virtual {p0, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 949
    :goto_2
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v5, v0}, Ljava/text/DecimalFormat;->setGroupingSize(I)V

    .line 950
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    const v6, 0x7f0e015f

    invoke-virtual {p0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormatSymbols;->setGroupingSeparator(C)V

    .line 952
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    const v6, 0x7f0e0158

    invoke-virtual {p0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormatSymbols;->setDecimalSeparator(C)V

    .line 955
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 956
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    sget-object v6, Lco/vine/android/util/Util;->DECIMAL_FORMAT_SYMBOLS:Ljava/text/DecimalFormatSymbols;

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormat;->setDecimalFormatSymbols(Ljava/text/DecimalFormatSymbols;)V

    .line 959
    if-eqz p3, :cond_0

    sget-object v5, Ljava/util/Locale;->KOREA:Ljava/util/Locale;

    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v5

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 960
    :cond_0
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v5, p1, p2}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v5

    .line 977
    :goto_3
    return-object v5

    .line 937
    .end local v0    # "groupingSeperatorSize":I
    .end local v1    # "hundredMillions":Z
    .end local v4    # "tenThousands":Z
    :cond_1
    const/4 v4, 0x0

    goto :goto_0

    .line 940
    .restart local v4    # "tenThousands":Z
    :cond_2
    const/4 v1, 0x0

    goto :goto_1

    .line 964
    .restart local v0    # "groupingSeperatorSize":I
    .restart local v1    # "hundredMillions":Z
    :cond_3
    long-to-double v5, p1

    const-wide v7, 0x412e848000000000L    # 1000000.0

    div-double v2, v5, v7

    .local v2, "n":D
    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    cmpl-double v5, v2, v5

    if-ltz v5, :cond_5

    .line 965
    if-eqz v1, :cond_4

    .line 966
    const-wide/high16 v5, 0x4059000000000000L    # 100.0

    div-double/2addr v2, v5

    .line 968
    :cond_4
    const v5, 0x7f0e015e

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    sget-object v8, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    const-wide/high16 v9, 0x4024000000000000L    # 10.0

    mul-double/2addr v9, v2

    invoke-static {v9, v10}, Ljava/lang/Math;->floor(D)D

    move-result-wide v9

    const-wide/high16 v11, 0x4024000000000000L    # 10.0

    div-double/2addr v9, v11

    invoke-virtual {v8, v9, v10}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {p0, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 970
    :cond_5
    long-to-double v5, p1

    const-wide v7, 0x40c3880000000000L    # 10000.0

    div-double v2, v5, v7

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    cmpl-double v5, v2, v5

    if-ltz v5, :cond_7

    .line 971
    if-eqz v4, :cond_6

    .line 972
    const-wide/high16 v5, 0x4024000000000000L    # 10.0

    div-double/2addr v2, v5

    .line 974
    :cond_6
    const v5, 0x7f0e0161

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    sget-object v8, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    const-wide/high16 v9, 0x4059000000000000L    # 100.0

    mul-double/2addr v9, v2

    invoke-static {v9, v10}, Ljava/lang/Math;->floor(D)D

    move-result-wide v9

    const-wide/high16 v11, 0x4024000000000000L    # 10.0

    div-double/2addr v9, v11

    invoke-virtual {v8, v9, v10}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {p0, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 977
    :cond_7
    sget-object v5, Lco/vine/android/util/Util;->DECIMAL_FORMAT:Ljava/text/DecimalFormat;

    invoke-virtual {v5, p1, p2}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 946
    .end local v2    # "n":D
    :catch_0
    move-exception v5

    goto/16 :goto_2
.end method

.method public static parseURI(Ljava/lang/String;)Ljava/net/URI;
    .locals 6
    .param p0, "uri"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 536
    :try_start_0
    new-instance v3, Ljava/net/URI;

    invoke-direct {v3, p0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 550
    :goto_0
    return-object v3

    .line 537
    :catch_0
    move-exception v3

    .line 540
    const/16 v3, 0x3a

    invoke-virtual {p0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 541
    .local v0, "colonIndex":I
    const/4 v3, -0x1

    if-eq v0, v3, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-eq v0, v3, :cond_0

    .line 542
    const/4 v3, 0x0

    invoke-virtual {p0, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 543
    .local v1, "scheme":Ljava/lang/String;
    add-int/lit8 v3, v0, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 545
    .local v2, "ssp":Ljava/lang/String;
    :try_start_1
    new-instance v3, Ljava/net/URI;

    const/4 v5, 0x0

    invoke-direct {v3, v1, v2, v5}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 546
    :catch_1
    move-exception v3

    .end local v1    # "scheme":Ljava/lang/String;
    .end local v2    # "ssp":Ljava/lang/String;
    :cond_0
    move-object v3, v4

    .line 550
    goto :goto_0
.end method

.method public static printCursorWindowStats()Ljava/lang/String;
    .locals 7

    .prologue
    .line 155
    const/4 v2, 0x0

    .line 157
    .local v2, "window":Landroid/database/CursorWindow;
    :try_start_0
    new-instance v3, Landroid/database/CursorWindow;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Landroid/database/CursorWindow;-><init>(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 158
    .end local v2    # "window":Landroid/database/CursorWindow;
    .local v3, "window":Landroid/database/CursorWindow;
    :try_start_1
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "printStats"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Class;

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 159
    .local v1, "m":Ljava/lang/reflect/Method;
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 160
    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v3, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 164
    if-eqz v3, :cond_0

    .line 165
    invoke-virtual {v3}, Landroid/database/CursorWindow;->close()V

    .line 168
    .end local v1    # "m":Ljava/lang/reflect/Method;
    .end local v3    # "window":Landroid/database/CursorWindow;
    :cond_0
    :goto_0
    return-object v4

    .line 161
    .restart local v2    # "window":Landroid/database/CursorWindow;
    :catch_0
    move-exception v0

    .line 162
    .local v0, "e":Ljava/lang/Exception;
    :goto_1
    :try_start_2
    const-string v4, "print cursor error"

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 164
    if-eqz v2, :cond_1

    .line 165
    invoke-virtual {v2}, Landroid/database/CursorWindow;->close()V

    .line 168
    :cond_1
    const/4 v4, 0x0

    goto :goto_0

    .line 164
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v4

    :goto_2
    if-eqz v2, :cond_2

    .line 165
    invoke-virtual {v2}, Landroid/database/CursorWindow;->close()V

    :cond_2
    throw v4

    .line 164
    .end local v2    # "window":Landroid/database/CursorWindow;
    .restart local v3    # "window":Landroid/database/CursorWindow;
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "window":Landroid/database/CursorWindow;
    .restart local v2    # "window":Landroid/database/CursorWindow;
    goto :goto_2

    .line 161
    .end local v2    # "window":Landroid/database/CursorWindow;
    .restart local v3    # "window":Landroid/database/CursorWindow;
    :catch_1
    move-exception v0

    move-object v2, v3

    .end local v3    # "window":Landroid/database/CursorWindow;
    .restart local v2    # "window":Landroid/database/CursorWindow;
    goto :goto_1
.end method

.method public static randomString(I)Ljava/lang/String;
    .locals 5
    .param p0, "length"    # I

    .prologue
    .line 249
    const/4 v2, 0x1

    if-ge p0, v2, :cond_0

    .line 250
    const/4 v2, 0x0

    .line 257
    :goto_0
    return-object v2

    .line 253
    :cond_0
    new-array v1, p0, [C

    .line 254
    .local v1, "randBuffer":[C
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, v1

    if-ge v0, v2, :cond_1

    .line 255
    sget-object v2, Lco/vine/android/util/Util;->numbersAndLetters:[C

    sget-object v3, Lco/vine/android/util/Util;->sRandom:Ljava/security/SecureRandom;

    const/16 v4, 0x47

    invoke-virtual {v3, v4}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v3

    aget-char v2, v2, v3

    aput-char v2, v1, v0

    .line 254
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 257
    :cond_1
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([C)V

    goto :goto_0
.end method

.method public static readFullyWriteTo(Ljava/io/InputStream;Ljava/io/OutputStream;I)I
    .locals 4
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "os"    # Ljava/io/OutputStream;
    .param p2, "bufferSize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 399
    new-array v0, p2, [B

    .line 401
    .local v0, "buf":[B
    const/4 v2, 0x0

    .line 402
    .local v2, "totalBytes":I
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "bytesRead":I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_1

    .line 403
    if-eqz p1, :cond_0

    .line 404
    const/4 v3, 0x0

    invoke-virtual {p1, v0, v3, v1}, Ljava/io/OutputStream;->write([BII)V

    .line 406
    :cond_0
    add-int/2addr v2, v1

    goto :goto_0

    .line 408
    :cond_1
    return v2
.end method

.method public static removeCache(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1146
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 1147
    .local v0, "dir":Ljava/io/File;
    if-nez v0, :cond_1

    .line 1157
    :cond_0
    :goto_0
    return-void

    .line 1150
    :cond_1
    invoke-static {v0}, Lco/vine/android/util/Util;->deleteFileRecursively(Ljava/io/File;)V

    .line 1152
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalFilesDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 1153
    if-eqz v0, :cond_0

    .line 1156
    invoke-static {v0}, Lco/vine/android/util/Util;->deleteFileRecursively(Ljava/io/File;)V

    goto :goto_0
.end method

.method public static restartApp(Landroid/content/Context;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x0

    .line 1463
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 1465
    .local v1, "launchIntent":Landroid/content/Intent;
    const-string v2, "alarm"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 1466
    .local v0, "am":Landroid/app/AlarmManager;
    const/4 v2, 0x1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    const-wide/16 v5, 0x3e8

    add-long/2addr v3, v5

    invoke-static {p0, v7, v1, v7}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 1468
    invoke-static {v7}, Ljava/lang/System;->exit(I)V

    .line 1469
    return-void
.end method

.method public static safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V
    .locals 4
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "size"    # Lco/vine/android/util/Util$ProfileImageSize;
    .param p2, "color"    # I

    .prologue
    .line 1037
    const/4 v1, -0x1

    .line 1038
    .local v1, "res":I
    sget-object v2, Lco/vine/android/util/Util$1;->$SwitchMap$co$vine$android$util$Util$ProfileImageSize:[I

    invoke-virtual {p1}, Lco/vine/android/util/Util$ProfileImageSize;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1049
    :goto_0
    if-nez p2, :cond_0

    .line 1050
    sget p2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    .line 1052
    :cond_0
    const/high16 v2, -0x1000000

    or-int/2addr p2, v2

    .line 1054
    :try_start_0
    invoke-virtual {p0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1055
    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {p0, p2, v2}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 1059
    :goto_1
    return-void

    .line 1040
    :pswitch_0
    const v1, 0x7f020069

    .line 1041
    goto :goto_0

    .line 1043
    :pswitch_1
    const v1, 0x7f020066

    .line 1044
    goto :goto_0

    .line 1046
    :pswitch_2
    const v1, 0x7f020065

    goto :goto_0

    .line 1056
    :catch_0
    move-exception v0

    .line 1057
    .local v0, "oom":Ljava/lang/OutOfMemoryError;
    const-string v2, "OOM has happened."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_1

    .line 1038
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    .locals 5
    .param p0, "spannable"    # Landroid/text/Spannable;
    .param p1, "span"    # Ljava/lang/Object;
    .param p2, "start"    # I
    .param p3, "end"    # I
    .param p4, "flags"    # I

    .prologue
    .line 1247
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1248
    invoke-interface {p0, p1, p2, p3, p4}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 1262
    :goto_0
    return-void

    .line 1250
    :cond_0
    if-ltz p2, :cond_1

    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v1

    if-ge p2, v1, :cond_1

    if-lt p3, p2, :cond_1

    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v1

    if-ge p3, v1, :cond_1

    .line 1252
    invoke-interface {p0, p1, p2, p3, p4}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 1255
    :cond_1
    :try_start_0
    invoke-interface {p0, p1, p2, p3, p4}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1256
    :catch_0
    move-exception v0

    .line 1257
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    const-string v1, "We got an IOOB while setting a span. {} {} {}"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "view"    # Landroid/view/View;
    .param p2, "visible"    # Z

    .prologue
    const/4 v2, 0x0

    .line 670
    const-string v1, "input_method"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 673
    .local v0, "inputMethodManager":Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_0

    .line 674
    if-eqz p2, :cond_1

    .line 675
    invoke-virtual {v0, p1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 680
    :cond_0
    :goto_0
    return-void

    .line 677
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    goto :goto_0
.end method

.method public static setTextWithSpan(Ljava/lang/Object;Ljava/lang/String;Landroid/widget/TextView;)V
    .locals 4
    .param p0, "span"    # Ljava/lang/Object;
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/widget/TextView;

    .prologue
    .line 1240
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 1241
    .local v0, "contentSb":Landroid/text/SpannableStringBuilder;
    const/4 v1, 0x0

    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-static {v0, p0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 1242
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1243
    return-void
.end method

.method public static showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 517
    const/4 v1, 0x1

    invoke-static {p0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 518
    .local v0, "t":Landroid/widget/Toast;
    const/16 v1, 0x11

    invoke-virtual {v0, v1, v2, v2}, Landroid/widget/Toast;->setGravity(III)V

    .line 519
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 520
    return-object v0
.end method

.method public static showCenteredToast(Landroid/content/Context;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resId"    # I

    .prologue
    const/4 v2, 0x0

    .line 477
    const/4 v1, 0x1

    invoke-static {p0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    .line 478
    .local v0, "t":Landroid/widget/Toast;
    const/16 v1, 0x11

    invoke-virtual {v0, v1, v2, v2}, Landroid/widget/Toast;->setGravity(III)V

    .line 479
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 480
    return-void
.end method

.method public static showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 496
    const/4 v1, 0x1

    invoke-static {p0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 497
    .local v0, "t":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 498
    return-void
.end method

.method public static showNoCameraToast(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 483
    const v0, 0x7f0e014e

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 484
    return-void
.end method

.method public static showShortCenteredToast(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 529
    invoke-static {p0, p1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 530
    .local v0, "t":Landroid/widget/Toast;
    const/16 v1, 0x11

    invoke-virtual {v0, v1, v2, v2}, Landroid/widget/Toast;->setGravity(III)V

    .line 531
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 532
    return-void
.end method

.method public static showTopToast(Landroid/content/Context;I)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resId"    # I

    .prologue
    const/4 v3, 0x0

    .line 506
    invoke-virtual {p0, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {p0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 507
    .local v0, "t":Landroid/widget/Toast;
    const/16 v1, 0x30

    invoke-virtual {v0, v1, v3, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 508
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 509
    return-void
.end method

.method public static startActionOnRecordingAvailable(Landroid/app/Activity;Landroid/content/Intent;I)V
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestId"    # I

    .prologue
    .line 420
    invoke-static {p0}, Lco/vine/android/util/Util;->isCapableOfRecording(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 421
    invoke-virtual {p0, p1, p2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 425
    :goto_0
    return-void

    .line 423
    :cond_0
    invoke-static {p0}, Lco/vine/android/util/Util;->showNoCameraToast(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static stripUsernameEntities(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 172
    invoke-static {p0}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 173
    .local v1, "username":Ljava/lang/String;
    sget-object v2, Lco/vine/android/util/Util;->PATTERN_USERNAME:Ljava/util/regex/Pattern;

    invoke-virtual {v2, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 174
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static styleSectionHeader(Landroid/content/Context;Landroid/widget/TextView;Landroid/widget/TextView;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sectionTitle"    # Landroid/widget/TextView;
    .param p2, "sectionSort"    # Landroid/widget/TextView;

    .prologue
    .line 1062
    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v1

    iget-object v0, v1, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    .line 1063
    .local v0, "font":Landroid/graphics/Typeface;
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1064
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1065
    return-void
.end method

.method public static toByteArray(Ljava/lang/Object;)[B
    .locals 5
    .param p0, "o"    # Ljava/lang/Object;

    .prologue
    .line 1004
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    const/16 v4, 0x200

    invoke-direct {v0, v4}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 1005
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    const/4 v2, 0x0

    .line 1007
    .local v2, "oos":Ljava/io/ObjectOutputStream;
    :try_start_0
    new-instance v3, Ljava/io/ObjectOutputStream;

    invoke-direct {v3, v0}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1008
    .end local v2    # "oos":Ljava/io/ObjectOutputStream;
    .local v3, "oos":Ljava/io/ObjectOutputStream;
    :try_start_1
    invoke-virtual {v3, p0}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    .line 1009
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v4

    .line 1013
    invoke-static {v3}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 1014
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    move-object v2, v3

    .end local v3    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v2    # "oos":Ljava/io/ObjectOutputStream;
    :goto_0
    return-object v4

    .line 1010
    :catch_0
    move-exception v1

    .line 1011
    .local v1, "e":Ljava/io/IOException;
    :goto_1
    const/4 v4, 0x0

    .line 1013
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 1014
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .line 1013
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    :goto_2
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 1014
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v4

    .line 1013
    .end local v2    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v3    # "oos":Ljava/io/ObjectOutputStream;
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v2    # "oos":Ljava/io/ObjectOutputStream;
    goto :goto_2

    .line 1010
    .end local v2    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v3    # "oos":Ljava/io/ObjectOutputStream;
    :catch_1
    move-exception v1

    move-object v2, v3

    .end local v3    # "oos":Ljava/io/ObjectOutputStream;
    .restart local v2    # "oos":Ljava/io/ObjectOutputStream;
    goto :goto_1
.end method

.method public static validateAndFixEntities(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1068
    .local p0, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-static {p0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 1069
    return-void
.end method
