.class public final Lcn/jpush/android/util/z;
.super Ljava/lang/Object;


# static fields
.field public static final a:Ljava/util/regex/Pattern;

.field public static final b:Ljava/util/regex/Pattern;

.field public static final c:Ljava/util/regex/Pattern;

.field public static final d:Ljava/util/regex/Pattern;

.field public static final e:Ljava/util/regex/Pattern;

.field public static final f:Ljava/util/regex/Pattern;

.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "K\u0001\u4e6bi\u9f8a%wR%\u0002o\u001bF\u001epHqO"

    const/4 v0, -0x1

    move-object v4, v3

    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v5, v1

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    :cond_0
    move-object v7, v1

    move v8, v6

    move v11, v5

    move-object v5, v1

    move v1, v11

    :goto_1
    aget-char v10, v5, v6

    rem-int/lit8 v9, v8, 0x5

    packed-switch v9, :pswitch_data_0

    const/16 v9, 0x2f

    :goto_2
    xor-int/2addr v9, v10

    int-to-char v9, v9

    aput-char v9, v5, v6

    add-int/lit8 v6, v8, 0x1

    if-nez v1, :cond_1

    move-object v5, v7

    move v8, v6

    move v6, v1

    goto :goto_1

    :cond_1
    move v5, v1

    move-object v1, v7

    :cond_2
    if-gt v5, v6, :cond_0

    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v5}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_1

    aput-object v1, v3, v2

    const/4 v2, 0x1

    const-string v1, "K\u0001\u4e6bi\u9f8a%wR%\u0002o\u001bF\u001epH![h\u001b%\'O"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "=rClttw\u0011\u0005\u0002OjF}\u008f8\ud7a5\uf96bi\ufde0\ufde5w\uff84\u0019ttw\u0011\u0005\u0002OjF}\u008f8\ud7a5\uf96bi\ufde0\ufde5w\uff84\u0018\u0002HpBnttw\u0011\u0005\u0002OjF}\u008f8\ud7a5\uf96bi\ufde0\ufde5w\uff84\u0019s;s@"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/util/z;->z:[Ljava/lang/String;

    const-string v1, "=r\n!]z&\n6_t&\n7Ft&\n\u001fLq?\r#Fy7\u0005+^g)\u001f1Xm 6mS=8\u0002>Sw\u0001\n&Kp<\u000c,F\u007f7\u0005+]f.\u001d3Vo\u0007B8\u0007v;\u001f8Lz7\u0017\'@z*\u0017\'tt9\u000f\"H}3\u0000(B{5\u00191Ym#\u0011\u0019\u0006i>0!E~7\u0004>rir\u000e Zi?0\'Jr(\u00180ZHs\u0017\"t|0\u0000)@g\u0007\u0017lHz,\u0017#tt8\u000f!Ir2\u0002(B{*\u001a6\\a/\u001c=r<&\u0003\u001fDx4\u00190ZH&C-As5\u0017-Aa&\u0002\u001fKp6\u0006*@d(\u00180r<&C.@w)\u0017.tp7\u00044r<&\u0000\u001fJr2\u0002)Ae(\u001c=UH&\u0007\u001fNw9\u0002/]f.\u001e2VH&C)Fy&\u0006+M|&\u00061\\p/\u00068BN;\u0008 Jr2\u0000(B{5\u001b5]f.\u001e2Xm#\u0011\u0019\u0006ir\u0005%Bp&\u0005![i40%Lp<\u000c-Cz*\u00191UHs\u0017l@g=\u0017+B<&C4]z&\u001b\u001fNp<\u000c,Dy7\u00056\\a-\u0012\u0019\u0006i+\n8]N?\u00047Zb\u0007\u00177tt8\u0008 Jr2\u0002.Dy7\u0005+]a/\u001d=UH&C0Jy&\u001f6Nc?\u00078[N9\u000f\"H}0\u0000(B{5\u001b6[c-\u0011\u0019\u0006i/0%H~)\u0012>ri,0%Lp=\u0002*ZH&\u001c\u001fIf\u0007\u0017lW{\u0006F\u0018\u0002% \u001c)\u001a#>\u0017<AIw7i\u001e$8^&\\&;R%E#=\u0017<AIw7i\u0017%;\u0000,Ml1\u0005.\u001bs&\u0013*s8\u0006F}[!8ZuV|o\n8W{\u0006F\u0018\u0002q?\t%\u001ft>\u0017<AIw7iH#-Yq\u001eq&\u0013*s8\u0006F,Hw1]%E\"<^wMw;\u0017<AIw7iGy9\u0001rNl;R!\\vm\n8W{\u0006F\u0018\u0002\u007f\"\n(_q6\u001b8W{\u0006F\u0018\u0002~=\t!L}.\u001d8W{\u0006F\u0018\u0002o9\u0000>N}s\u0017=tp.\u001e\u0019So\u0001\n)XHs"

    const/4 v0, -0x1

    :goto_3
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-gt v2, v4, :cond_8

    :cond_3
    move-object v4, v1

    move v5, v3

    move v11, v2

    move-object v2, v1

    move v1, v11

    :goto_4
    aget-char v7, v2, v3

    rem-int/lit8 v6, v5, 0x5

    packed-switch v6, :pswitch_data_2

    const/16 v6, 0x2f

    :goto_5
    xor-int/2addr v6, v7

    int-to-char v6, v6

    aput-char v6, v2, v3

    add-int/lit8 v3, v5, 0x1

    if-nez v1, :cond_7

    move-object v2, v4

    move v5, v3

    move v3, v1

    goto :goto_4

    :pswitch_2
    const/16 v9, 0x15

    goto :goto_2

    :pswitch_3
    const/16 v9, 0x5a

    goto :goto_2

    :pswitch_4
    const/16 v9, 0x6b

    goto :goto_2

    :pswitch_5
    const/16 v9, 0x44

    goto :goto_2

    :pswitch_6
    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->c:Ljava/util/regex/Pattern;

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/util/z;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/z;->a:Ljava/util/regex/Pattern;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v0, "<&"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-gt v1, v3, :cond_6

    :cond_4
    move-object v3, v0

    move v4, v2

    move v11, v1

    move-object v1, v0

    move v0, v11

    :goto_6
    aget-char v7, v1, v2

    rem-int/lit8 v5, v4, 0x5

    packed-switch v5, :pswitch_data_3

    const/16 v5, 0x2f

    :goto_7
    xor-int/2addr v5, v7

    int-to-char v5, v5

    aput-char v5, v1, v2

    add-int/lit8 v2, v4, 0x1

    if-nez v0, :cond_5

    move-object v1, v3

    move v4, v2

    move v2, v0

    goto :goto_6

    :pswitch_7
    const/16 v5, 0x15

    goto :goto_7

    :pswitch_8
    const/16 v5, 0x5a

    goto :goto_7

    :pswitch_9
    const/16 v5, 0x6b

    goto :goto_7

    :pswitch_a
    const/16 v5, 0x44

    goto :goto_7

    :cond_5
    move v1, v0

    move-object v0, v3

    :cond_6
    if-gt v1, v2, :cond_4

    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/z;->c:Ljava/util/regex/Pattern;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->d:Ljava/util/regex/Pattern;

    const-string v1, "N;F>n8\u0000[i\u0016Iq7jsJ\u0006N\u0018\u0002Iq6?\u001e9h^rRI\u001a0%\u0002o\u001bF\u001e\u001f8c6\u001fN8 *iu%wR\u0018\u0002H![h\u0019!\'C\u0018\u0001N;F>n8\u0000[i\u0016H\u0001\niUTw1t\u0002,\u0006F\u0019T%vYqR<q"

    const/4 v0, 0x2

    goto/16 :goto_3

    :pswitch_b
    const/16 v6, 0x15

    goto/16 :goto_5

    :pswitch_c
    const/16 v6, 0x5a

    goto/16 :goto_5

    :pswitch_d
    const/16 v6, 0x6b

    goto/16 :goto_5

    :pswitch_e
    const/16 v6, 0x44

    goto/16 :goto_5

    :cond_7
    move v2, v1

    move-object v1, v4

    :cond_8
    if-gt v2, v3, :cond_3

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_4

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->a:Ljava/util/regex/Pattern;

    const-string v1, "=rT~\u0007}.\u001f4S}.\u001f4\\i\u0012\u001f0_i\u0012\u001f0_f&\u00190\\e&90\\esQ\u0018\u0000IuC{\u0015=eQ\u001fN8 *iu%wR\u0018\u000bIw7\u001bs;\u0006@\u0018\u000eIp7cs=\u0006B\u0018\u0003Ia7{s3\u0006V\u0019S=eQ\u0018\nN;F\"n8\u001c[i\u0016H!Y9\u0006<!Zh\u0019!\'C{\u0015I`C{\u0015N;F>n8\u0000[i\u0016I~7isJ\u0006E\u0018\u0004I{7ns2\u0006C\u0018\u0006Iv7\u007fs*\u0006M\u0018\u0012H&C{\u0015I\u007f0%\u0002s\u001bF\u0002\u001f8c6?\u001dhsB?\u001e9h^9\u0006*\u0006+m\u0010<eCl\u0010/rT~ttw\u0011\u0005\u0002OjF}\u008f8\ud7a5\uf96bi\ufde0\ufde5w\uff84\u0019ttw\u0011\u0005\u0002OjF}\u008f8\ud7a5\uf96bi\ufde0\ufde5w\uff84\u0018\u0002H![h\u0019!\'7j\u0006>rT~\u0007*`\n!]z&\n6_t&\n7Ft&\n\u001fLq?\r#Fy7\u0005+^g)\u001f1Xm 6mS=eQ&Fo&\t\u001fNw>\u000e\"H}3\u0001)Az(\u00180Yb#\u0011\u0019\u0006irT~Lt.\u0017\'@x&\u0008+@e&\u0008\u001fNv>\r#G|1\u0007)Az(\u001e2Wl 6mSq\u0001\u000e.Dx5\u0011\u0019S=eQ!K`&\u000e\u001fLp=\u00197[`\u0007B8IN3\u0001/Bz(68\u0007*`\u000c+Yi=0%Mq?\r#G|6\u0006*_d(\u00180Zb#6mS}\u0001\u0000)Ag.\u001e\u0019S=eQ-As5\u0017-Aa&\u0002\u001fKp6\u0006*@d(\u00180r<&C{\u0015\u007f5\t7S\u007f\u0001\u000e)@e\u0007B8DN?\u000c,Fx4\u001b6Xl 68CN;\t\'F~(\u00180Zc#68\u0007*`\u0006-Ci7\u0004&Fi7\u001e7J`7\u0017)tt9\u000f!H}1\u0007)Az*\u001a6\\a/\u001d3Wl 6mS=eQ*Nx?\u0017*Ja&\u0005\u001fNv?\r#Fy5\u001b6Zo\u0007B8\u0007*`\u00046Hi5\u0006mS=eQ4]z&\u001b\u001fNp<\u000c,Dy7\u00056\\a-\u0012\u0019\u0006i+\n8]N?\u00047Zb\u0007\u00177tt8\u0008 Jr2\u0002.Dy7\u0005+]a/\u001d=UH&C{\u0015a?\u00078[g;\u001d!Ci.0\'Ks=\u0003.Dy7\u0005+_g.\u001d3UHs\u00171tt=\u00007Vo\u0007\u00172tt9\u000e#F{/68XN<\u0018\u0019S=eQ<AIw7i\u001fo-\u0006q\u0019q&\u0013*s8\u0006Fu\u001ewo\t7\u001ctc\n.\u0019r&\u0013*s8\u0006F|\u001ft1\u0003&V~4\u0001pIi\"\u0005\u0018\u0002IwR0\u001bwkZ=F ;\u0017<AIw7iKp8\ntNq&\u0013*s8\u0006F#\u0019bh^uKi\"\u0005\u0018\u0002Iw\u0003#M~l\n.\u0018soX&Mt&\u0013*s8\u0006F,Cv0]%Vtc\u000e7L\";\u0017<AIw7iEm;\u00074Ky*\u0017<AIw7iDr8\u000e\'Ga,\u0017<AIw7iUv1\u0011%G<&\u0012\u001fJa/68UN;\u00063r<s\u0017l\u0010/rT~\u001d \u0001[i\u001aH&Y\u001f\u001f8n6\u001f\u001f8c68t%wZ\u0019t%wR\u0019T\'\'\u0017\u001f\u001e8c6\u001f\u001f8c68t$wR\u0019\u0006ItC{\u0015\'o0t\u0002 \u0007\u0017vt%w_\u0019t%wR\u0019SNjFurNjF}rnh\u00168t$wR\u0019t%wR\u0019SNkF}rijB\u0018\u0001=eQv\u001aNjFqrih0t\u0002!\u00070t\u0002,\u0007\u0017\u001f\u001f8k6\u001f\u001f8c6?\u001dh&0u\u0002,\u00070t\u0002,\u0007\u0017\u001f\u001e8c68\u001f<\u0006El\u0010/h^\u001f\u001f8o68\u001dNjFprNjF}ri\u0001[i\u001eH\u0001[i\u0016H!Y9SNkF}rNjF}ri\u0001[i\u0016HsBm\u0007*`7~sq!Zh\u001ahsTm\u0007IuC{\u0015=eQ\u001fN8 *iu%wR\u00e4\u0002\ud7ea\uf95aF\ufd8b\ufddf8\uffb57\u007fs:\u0006T\u0018\u0015I\u001a7bs(\u0006H\u0018QIw7js>\u0006J\u0018\u0005I}7ls<\u0006G\u0018pHs\u0017l\u0010/\u0006N\u001fN8<*ii%wR\u0019T\'\'Bm\u0005<eC{\u0015I8\u0017`\u0006"

    const/4 v0, 0x0

    goto/16 :goto_3

    :pswitch_f
    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->b:Ljava/util/regex/Pattern;

    const-string v1, "=rYqt%w^\u0019S\'\u0001[i\u001bH\u0001[i\u0016H&0t\u0002$\u00070t\u0002,\u0007\u0010vRi\u0001Zi\u0016H\u0001[i\u0016H&0u\u0002,\u0007B\u0018\u0001=h^\u001f\u001f8o68\u001dNjFprNjF}ri\u0001[i\u001eH\u0001[i\u0016H!Y9SNkF}rNjF}ri\u0001Zi\u0016H&[ms;rYqt%w^\u0019S\'\u0001[i\u001bH\u0001[i\u0016H&0t\u0002$\u00070t\u0002,\u0007\u0010vRi\u0001Zi\u0016H\u0001[i\u0016H&0u\u0002,\u0007\u0017t\u0006ItCv\u001aNjFqrih0t\u0002!\u00070t\u0002,\u0007\u0017\u001f\u001f8k6\u001f\u001f8c6?\u001dh&0u\u0002,\u00070t\u0002,\u0007\u0017\u001f\u001f8c6m\u0006"

    const/4 v0, 0x1

    goto/16 :goto_3

    :pswitch_10
    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->e:Ljava/util/regex/Pattern;

    const-string v1, "=\u0006@\u001f\u001f8c6otIwK\u0018\u0001HpB{\u0007Ir0t\u0002,\u0007@\u0018\u0006N\u0006Fds;\u0007Am\u0010=\u0001[i\u0016H\u0001[i\u0016IwK\u0018\u0001H\u0001[i\u0016IwK\u0018\u0001Hq0t\u0002,\u0007B"

    const/4 v0, 0x3

    goto/16 :goto_3

    :pswitch_11
    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/z;->f:Ljava/util/regex/Pattern;

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch

    :pswitch_data_4
    .packed-switch 0x0
        :pswitch_f
        :pswitch_6
        :pswitch_10
        :pswitch_11
    .end packed-switch
.end method

.method public static a(Ljava/util/Set;)I
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    const/4 v1, 0x0

    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    return v0

    :cond_1
    invoke-interface {p0}, Ljava/util/Set;->size()I

    move-result v0

    const/16 v2, 0x64

    if-le v0, v2, :cond_2

    sget v0, Lcn/jpush/android/api/d;->g:I

    goto :goto_0

    :cond_2
    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-nez v0, :cond_4

    sget v0, Lcn/jpush/android/api/d;->e:I

    goto :goto_0

    :cond_4
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    array-length v3, v3

    const/16 v4, 0x28

    if-le v3, v4, :cond_5

    sget v0, Lcn/jpush/android/api/d;->f:I

    goto :goto_0

    :cond_5
    sget-object v3, Lcn/jpush/android/util/z;->z:[Ljava/lang/String;

    aget-object v3, v3, v1

    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_3

    sget v0, Lcn/jpush/android/api/d;->e:I

    goto :goto_0

    :cond_6
    move v0, v1

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)Z
    .locals 2

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcn/jpush/android/util/z;->z:[Ljava/lang/String;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;)I
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-static {p0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    array-length v1, v1

    const/16 v2, 0x28

    if-le v1, v2, :cond_2

    sget v0, Lcn/jpush/android/api/d;->d:I

    goto :goto_0

    :cond_2
    sget-object v1, Lcn/jpush/android/util/z;->z:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-nez v1, :cond_0

    sget v0, Lcn/jpush/android/api/d;->c:I

    goto :goto_0
.end method
